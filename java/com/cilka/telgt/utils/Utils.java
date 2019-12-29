package com.cilka.telgt.utils;

import com.cilka.telgt.Main;
import com.cilka.telgt.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class Utils {

	private static Map<String,ModOptions> modOptions= new HashMap(){
        {put("glass", new ModOptions(Material.GLASS,SoundType.GLASS,BlockRenderLayer.TRANSLUCENT));}
        {put("stone", new ModOptions(Material.ROCK, SoundType.STONE, BlockRenderLayer.SOLID));}
        {put("grass", new ModOptions(Material.GRASS, SoundType.GROUND, BlockRenderLayer.SOLID));}
        {put("leaves", new ModOptions(Material.LEAVES, SoundType.PLANT, BlockRenderLayer.SOLID));}
        {put("wool", new ModOptions(Material.CLOTH, SoundType.CLOTH, BlockRenderLayer.SOLID));}
        {put("wood", new ModOptions(Material.WOOD, SoundType.WOOD, BlockRenderLayer.SOLID));}
        {put("ice", new ModOptions(Material.ICE, SoundType.GLASS, BlockRenderLayer.SOLID));}

    };
	//todo: It may be better to use tab name instead of block/item name for key to reduce amount of maps and for loops passed around
	public static Map<String, Block> blocks = new HashMap<>();
	public static Map<String, Item> items = new HashMap<>();
	public static Map<String, CreativeTabs> tabs =  new HashMap<>();
	public static Map<String,Set<String>> blocksInTab = new HashMap<>();
	private static Map<Integer, String> blockOrderFromFile = new HashMap<>();
	public static Map<Integer,String> blockOrder = new TreeMap<>();
	public static void Generate(String modId)
	{
		try {
			//File inputFile = new File("input.txt");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			ModRegistryHandler handler = new ModRegistryHandler(modId,saxParser.getXMLReader());
			saxParser.parse(Utils.class.getResourceAsStream("/assets/tel/config/telregistery.xml"), handler);
			//modOptions.putAll(translateModOptions(handler.getDefaultOptions()));
			System.out.println("Mod options registered.");
            for (String key: handler.getTabs().keySet()) {
               Map<String, Section> sections =handler.getTabs().get(key).getSections();
				List<Map<String,Block>> sectionBlocks = new ArrayList<>();
				Set<String> tabBlocks = new HashSet<String>();
                for ( String sectionKey : sections.keySet()) {
                    tabBlocks.addAll(sections.get(sectionKey).getBlocks().keySet());
                    sectionBlocks.add(translateBlocks(sections.get(sectionKey).getBlocks()
							,modOptions.get(sections.get(sectionKey).getDefaultOption())
							,handler.getTabs().get(key).getIcon()));

                }
                blocksInTab.put(key, tabBlocks);
                translateTabs (modId, handler.getTabs().get(key));
                blocks.putAll(finalizeBlocks(tabs.get(key), sectionBlocks));

            }
            blockOrder = new TreeMap<>(blockOrderFromFile);
         //   finalizeLoadOrder(blockOrderFromFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Map<String,Block> finalizeBlocks(CreativeTabs tab, List<Map<String,Block>> blocks)
	{
	    Map<String, Block> flat = new HashMap<>();
	    for(Map<String,Block> f :  blocks) {

            for (Block b :f.values()) {
                b.setCreativeTab(tab);
              //  determinBlockOrder(b.getLocalizedName());

            }  flat.putAll(f);

        }
		return flat;
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
    public static void printBlocksInTab()
    {
        blocksInTab.forEach((k,v) -> {
                    System.out.println(k);
                    v.forEach( block -> System.out.println("\t"+block));
                    System.out.println();
                }
                );
    }
    private static void populateLoadOrder(Map<String,Integer> map, String resource)
    {
       InputStream blockOrder =  Utils.class.getResourceAsStream(resource);
       try{
           BufferedReader reader = new BufferedReader (new InputStreamReader(blockOrder));
           if(blockOrder != null)
           {
               String s;
               while((s = reader.readLine()) != null)
               {
                  String [] kv =  s.split(":");
                map.put(kv[0], Integer.parseInt(kv[1]));
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally{
           try {
               blockOrder.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
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
                case "dirt":{
                    b = new BaseDirt(key);
                    break;
                }
                case "leaves":{
                    b = new BaseLeaf().setRegistryName(Main.MODID,key).setTranslationKey(key);
                    break;
                }
                case "lava":{
                    b = new BaseStaticLiquid(Material.LAVA).setRegistryName(Main.MODID,key).setTranslationKey(key).setHardness(100.0F).setLightLevel(1.0F);
                    break;
                }
                case "ice":{
                    b = new BlockIce().setRegistryName(Main.MODID,key).setTranslationKey(key);
                    break;
                }
                case "snow":{
                    b = new BaseBlockSnow().setRegistryName(Main.MODID,key).setTranslationKey(key);
                    break;
                }
                case "glass":{
                    b = new BaseBlock(key, new ModOptions(defaults.getMaterial(), defaults.getSound(), defaults.getLayer(), true));
                    break;
                }
            }
            blockOrderFromFile.put((int)raw.get(key).get("id"),key);
            temp.put(key, b);

        }
		return temp;
    }
	private static Map <String,ModOptions> translateModOptions(Map<String, Map<String,Object>> raw)
    {
        HashMap<String,ModOptions> processed =  new HashMap();
        for (String key: raw.keySet()) {
            try {
                System.out.println("default type: " + key + " material: " +raw.get(key).get("material") + " sound: " +raw.get(key).get("sound") + " renderLayer: " + raw.get(key).get("renderLayer"));
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
