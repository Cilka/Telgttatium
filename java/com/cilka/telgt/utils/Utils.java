package com.cilka.telgt.utils;

import com.cilka.telgt.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Utils {

	private static Map<String,ModOptions> modOptions= new HashMap<>();
	//todo: It may be better to use tab name instead of block/item name for key to reduce amount of maps and for loops passed around
	public static Map<String, Block> blocks = new HashMap<>();
	public static Map<String, Item> items = new HashMap<>();
	public static Map<String, CreativeTabs> tabs =  new HashMap<>();
	public static void Generate(String modId)
	{
		try {
			//File inputFile = new File("input.txt");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			ModRegistryHandler handler = new ModRegistryHandler(modId,saxParser.getXMLReader());
			saxParser.parse(Utils.class.getResourceAsStream("/assets/tel/config/telregistery.xml"), handler);
			modOptions.putAll(translateModOptions(handler.getDefaultOptions()));
			System.out.println("Mod options registered.");
            for (String key: handler.getTabs().keySet()) {
               Map<String, Section> sections =handler.getTabs().get(key).getSections();
				Map<String,Block> sectionBlocks = null;
                for ( String sectionKey : sections.keySet()) {
                    sectionBlocks =translateBlocks(sections.get(sectionKey).getBlocks()
							,modOptions.get(sections.get(sectionKey).getDefaultOption())
							,handler.getTabs().get(key).getIcon());
                }
                translateTabs (modId, handler.getTabs().get(key));

            	blocks.putAll(setCreativeTabs(tabs.get(key),sectionBlocks));
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static Map<String,Block>  setCreativeTabs(CreativeTabs tab,Map<String,Block> blocks)
	{
		for(Block b : blocks.values())
		{
			b.setCreativeTab(tab);
		}
		return blocks;
	}
	private static void translateTabs(String modId, Tab tab)
    {
        tabs.put(tab.getName(), new CreativeTabs(modId + "." + tab.getName()) {
            @SideOnly(Side.CLIENT)
            @Override
            public ItemStack createIcon() {
                return blocks.containsKey(tab.getIcon()) ? new ItemStack(blocks.get(tab.getIcon())) : new ItemStack(items.get(tab.getIcon()));
            }
        });
    }
	private static Map<String, Block> translateBlocks(Map<String, Map<String,Object>> raw, ModOptions defaults, String tab){
	    Map<String, Block> temp = new HashMap<>();
		for(String key : raw.keySet())
        {

            Block b = null;
            switch(raw.get(key).get("type").toString()){
                case "block" :{
                    b = new BaseBlock(key, defaults);
                    break;
                }
				case "pane":{
					b = new BasePane(key, defaults);
					break;
				}
				case "grass":{
					b  = new BaseGrass(key, defaults);
					break;
				}
				case "column":{
					b = new BaseColumn(key, defaults);
					break;
				}
            }
            temp.put(key, b);

        }
		return temp;
    }
	private static Map <String,ModOptions> translateModOptions(Map<String, Map<String,Object>> raw)
    {
        HashMap<String,ModOptions> processed =  new HashMap();
        for (String key: raw.keySet()) {
            try {
                processed.put(key,new ModOptions(
                        translateMaterial(raw.get(key).get("material").toString()),
                        translateSoundType(raw.get(key).get("sound").toString()),
                        translateBlockRenderLayer(raw.get(key).get("renderLayer").toString())));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }
        return processed;
    }
    private static Material translateMaterial(String material) throws IllegalAccessException {
        Material m = (Material) Arrays.stream(Material.class.getFields())
                .filter( f-> f.getName().equalsIgnoreCase(material))
                .findFirst()
                .get()
                .get(Material.class.getFields());

        return m;
    }
    private static SoundType translateSoundType(String sound) throws IllegalAccessException {
        SoundType m = (SoundType) Arrays.stream(SoundType.class.getFields())
                .filter( f-> f.getName().equalsIgnoreCase(sound))
                .findFirst()
                .get()
                .get(SoundType.class.getFields());

        return m;
    }
    private static BlockRenderLayer translateBlockRenderLayer(String renderLayer) throws IllegalAccessException {
        BlockRenderLayer m = (BlockRenderLayer) Arrays.stream(BlockRenderLayer.class.getFields())
                .filter( f-> f.getName().equalsIgnoreCase(renderLayer))
                .findFirst()
                .get()
                .get(BlockRenderLayer.class.getFields());

        return m;
    }
}
