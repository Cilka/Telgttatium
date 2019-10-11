package com.cilka.telgt;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;

import com.cilka.telgt.Main;
import com.cilka.telgt.block.BaseBlock;

import com.cilka.telgt.init.ModBlocks;
import com.cilka.telgt.item.*;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = Main.MODID)
public final class EventSubscriber {
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {

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
	}
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
	

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
