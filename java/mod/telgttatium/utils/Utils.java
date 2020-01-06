package mod.telgttatium.utils;

import mod.telgttatium.block.TelOre;
import mod.telgttatium.block.TieredOre;
import mod.telgttatium.item.WingPickaxe;
import mod.telgttatium.item.BasePickaxe;
import mod.telgttatium.Main;
import mod.telgttatium.utils.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
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
	private static Map<Integer, String> blockOrderFromFile = new HashMap<>();
	private static  Map<Integer, String> itemOrderFromFile =  new HashMap<>();

	public static Map<Integer,String> blockOrder = new TreeMap<>();
	public static Map<Integer,String> itemOrder = new TreeMap<>();
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
				List<Map<String,Item>> sectionItems = new ArrayList<>();
                for ( String sectionKey : sections.keySet()) {
                    if(sections.get(sectionKey).getBlocks() != null && sections.get(sectionKey).getBlocks().size() > 0 ) {
                        sectionBlocks.add(translateBlocks(sections.get(sectionKey).getBlocks()
                                , modOptions.get(sections.get(sectionKey).getDefaultOption())));
                    }
                    else if(sections.get(sectionKey).getItems() != null && sections.get(sectionKey).getItems().size() > 0 ){
                        sectionItems.add(translateItems(sections.get(sectionKey).getItems()));
                    }

                }
                translateTabs (modId, handler.getTabs().get(key));
                blocks.putAll(finalizeBlocks(tabs.get(key), sectionBlocks));
                items.putAll(finalizeItems(tabs.get(key), sectionItems));

            }
            blockOrder = new TreeMap<>(blockOrderFromFile);
            itemOrder =  new TreeMap<>(itemOrderFromFile);
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

            }  flat.putAll(f);

        }
		return flat;
	}
	private static Map<String,Item> finalizeItems(CreativeTabs tab, List<Map<String,Item>> items)
    {
        Map<String, Item> flat = new HashMap<>();
        for(Map<String,Item> f :  items) {

            for (Item i :f.values()) {
                i.setCreativeTab(tab);

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
	private static Map<String, Block> translateBlocks(Map<String, Map<String,Object>> raw, ModOptions defaults){
	    Map<String, Block> temp = new HashMap<>();
		for(String key : raw.keySet())
        {

            Block b = null;
            Map<String, Object> prop =raw.get(key);
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
                case "tieredOre":{
                    b = new TieredOre(prop.get("drop").toString(),(boolean)prop.get("finalStep"), (int)prop.get("dropAmount"), (int)prop.get("harvestLevel"))
                            .setRegistryName(Main.MODID,key)
                            .setTranslationKey(key)
                            .setHardness(4)
                            .setResistance(6);
                    break;
                }
                case "ore":{
                    b = new TelOre(prop.get("drop").toString(),(int)prop.get("dropAmount"), (int)prop.get("harvestLevel"))
                            .setRegistryName(Main.MODID,key)
                            .setTranslationKey(key)
                            .setHardness(3)
                            .setResistance(5);
                    break;
                }
            }
            blockOrderFromFile.put((int)raw.get(key).get("id"),key);
            temp.put(key, b);

        }
		return temp;
    }


    private static Map<String,Item> translateItems(Map<String, Map<String,Object>> raw)
    {
        Map <String, Item> temp = new HashMap<>();
        for(String key : raw.keySet())
        {

            Item i = null;
            switch(raw.get(key).get("type").toString()){
                case "item" :{
                 i = new Item().setRegistryName(Main.MODID,key).setTranslationKey(key);
                 break;
                }
                case "food": {
                    //todo: fill out the xml portion later
                    i = new ItemFood(3,3,false).setRegistryName(Main.MODID,key).setTranslationKey(key);
                    break;
                }
                case "wing_pickaxe":{
                    //todo: make a way to use custom ToolMaterials.
                    Map<String,Object> props = raw.get(key);
                    i = new WingPickaxe((int)props.get("maxUses"),(int)props.get("harvestLevel"), (float)props.get("efficiency"), (float)props.get("attackDamage"), (float)props.get("attackSpeed"))
                            .setRegistryName(Main.MODID,key).setTranslationKey(key);

                    break;
                }
                case "pickaxe":{
                    Map<String,Object> props = raw.get(key);
                    i = new BasePickaxe((int)props.get("maxUses"), (int)props.get("harvestLevel"), (float)props.get("efficiency"), (float)props.get("attackDamage"), (float)props.get("attackSpeed"))
                            .setRegistryName(Main.MODID,key).setTranslationKey(key);
break;

                }
                case "sword":{
                    //todo: see pickaxe
                    i = new ItemSword(Item.ToolMaterial.DIAMOND).setRegistryName(Main.MODID,key).setTranslationKey(key);
                    break;
                }
            }
            itemOrderFromFile.put((int)raw.get(key).get("id"),key);
            temp.put(key, i);
        }
        return temp;
    }

}
