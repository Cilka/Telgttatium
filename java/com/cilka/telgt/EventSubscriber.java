package com.cilka.telgt;
import com.cilka.telgt.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Main.MODID)
public final class EventSubscriber {
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
/*
		for(Field f : ModBlocks.class.getFields()) 
		{
			try {
				event.getRegistry().registerAll(ConvertToItemBlocks((Block[])f.get(ModBlocks.class)));
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 */
		for(String s : Utils.blocks.keySet())
		{
			event.getRegistry().register(ConvertToItemBlock(Utils.blocks.get(s)));
		}
	}
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
	
/*
		for(Field f : ModBlocks.class.getFields()) 
		{
			try {
				event.getRegistry().registerAll((Block[])f.get(ModBlocks.class));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		for(String s : Utils.blocks.keySet() ){
			event.getRegistry().register(Utils.blocks.get(s));

		}
	
	}

	private static Item ConvertToItemBlock(Block block)
	{
		return new ItemBlock(block).setRegistryName(block.getRegistryName());
	}
	private static Item[] ConvertToItemBlocks(Block[] blocks)
	{
		 Item[] items =  new Item[blocks.length];
		 for(int i  =0; i < items.length; i++)
		 {
			 items[i] = new ItemBlock(blocks[i]).setRegistryName(blocks[i].getRegistryName());
		 }
		 return items;
				 
	}
	
	
	
}
