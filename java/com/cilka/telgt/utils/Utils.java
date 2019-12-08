package com.cilka.telgt.utils;

import com.cilka.telgt.block.BaseBlock;
import com.cilka.telgt.block.BlockOptions;
import com.cilka.telgt.item.ItemOptions;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.util.Map;
public class Utils {
	public static BaseBlock[] GenerateBlocksFromTextureFolder(String path)
	{
		return GenerateBlocksFromTextureFolder(path, null, BaseBlock.class);
	}
	public static BaseBlock[] GenerateBlocksFromTextureFolder(String path, BlockOptions options){
		return GenerateBlocksFromTextureFolder(path, options, BaseBlock.class);
	}
	public static <T extends BaseBlock> BaseBlock[] GenerateBlocksFromTextureFolder(String path, BlockOptions options, Class<T> clazz) {
		BaseBlock[] blocks = null;
		path = "textures.blocks." + path;


				String[] types = buildEntityList(path);
				blocks = new BaseBlock[types.length];
				try{
				for(int count = 0; count < blocks.length; count++)
				{
					blocks[count] = (options == null ?
							clazz.getConstructor(String.class).newInstance(types[count])
							:clazz.getConstructor(String.class,BlockOptions.class).newInstance(types[count],options));
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}


		return blocks;
	}

	public static <T extends Item> Item[] GenerateItemsFromTextureFolder(String path, ItemOptions options, Class<T> clazz ){
		Item[] items = null;
		path = "textures.items." + path;


		String[] types = buildEntityList(path);
		items = new Item[types.length];
		try{
			for(int count = 0; count < items.length; count++)
			{
				items[count] = (options == null ?
						clazz.getConstructor(String.class).newInstance(types[count])
						:clazz.getConstructor(String.class,BlockOptions.class).newInstance(types[count],options));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return items;
	}
	public static BaseBlock[] GenerateBlocksFromList(String [] list, BlockOptions options)
	{
		BaseBlock [] blocks =  new BaseBlock[list.length];
		for(int i =0; i < list.length; i++)
		{
			String blockName =  list[i];
			blocks[i] =  options == null ? new BaseBlock(blockName): new BaseBlock(blockName, options) ;
		}
		return blocks;
	}
	public static BaseBlock[] AddBlocksToTab(BaseBlock[] blocks, CreativeTabs tab)
	{

		for(Block block : blocks)
		{
			block.setCreativeTab(tab);
		}

		return blocks;
	}

	private static String [] buildEntityList(String path)
	{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		String [] types = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(Utils.class.getResourceAsStream("/assets/tel/config/entitydb.xml"));
			NodeList list  = doc.getElementsByTagName("dir");
			for(int i =0; i < list.getLength() && types == null; i++) {
				if (path.equalsIgnoreCase(list.item(i).getAttributes().item(0).getNodeValue())) {

					types = list.item(i).getTextContent().replaceAll(" ", "").replaceAll("\t", "").replaceFirst("\\n","").split("\\n");
				}
			}
		} catch( Exception e)
		{
			e.printStackTrace();
		}
		return types;
	}

	public static void Generate()
	{
		try {
			//File inputFile = new File("input.txt");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			TabHandler handler = new TabHandler(saxParser.getXMLReader());
			saxParser.parse(Utils.class.getResourceAsStream("/assets/tel/config/telregistery.xml"), handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
