package com.cilka.telgt;

import com.cilka.telgt.block.BaseBlock;
import com.cilka.telgt.block.BlockOptions;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
			Document doc = dBuilder.parse(com.cilka.telgt.Utils.class.getResourceAsStream("/assets/tel/config/entitydb.xml"));
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
}
