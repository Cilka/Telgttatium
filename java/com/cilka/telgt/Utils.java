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
		//com.cilka.telgt.Utils.class.getResourceAsStream("alltextures.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(com.cilka.telgt.Utils.class.getResourceAsStream("/assets/tel/config/entitydb.xml"));
			NodeList list  = doc.getElementsByTagName("dir");
			for(int i =0; i < list.getLength(); i++)
			{
				if(path.equalsIgnoreCase(list.item(i).getAttributes().item(0).getNodeValue())){

				String[] types = list.item(i).getTextContent().replaceAll(" ","").replaceAll("\t", "").split("\\n");
				int arrayCount = 0;
				blocks = new BaseBlock[types.length -1];
				for(String name : types)
				{
					if(name.isEmpty())
					{
						continue;
					}
					blocks[arrayCount] = (options == null ?
							clazz.getConstructor(String.class).newInstance(name)
							:clazz.getConstructor(String.class,BlockOptions.class).newInstance(name,options));
					arrayCount++;
				}
				break;
			}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
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
	
}
