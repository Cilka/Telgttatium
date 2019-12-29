package com.cilka.telgt.client;

import com.cilka.telgt.Main;

import com.cilka.telgt.utils.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid= Main.MODID, value = Side.CLIENT)
public final class ClientEventSubscriber {
	  @SubscribeEvent
	    public static void registerModels(ModelRegistryEvent event) {
           /*
			for(Field f : ModBlocks.class.getFields()) 
			{
				try {
					for(Block b : ((BaseBlock[])f.get(ModBlocks.class)))
					{
						registerModel(Item.getItemFromBlock(b));
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			for(Field f : ModItems.class.getFields()){
				try{
				for(Item i: ((Item[])f.get(ModItems.class))){
					registerModel(i);
				}
				} catch(Exception e){
					e.printStackTrace();
				}
			}*/

	  		for(int i : Utils.blockOrder.keySet())
			{
				System.out.println(Utils.blockOrder.get(i) +" : <id>" + i +"</id>");
				registerModel(Item.getItemFromBlock(Utils.blocks.get(Utils.blockOrder.get(i))));
			}

	  }

	    private static void registerModel(Item item) {
	    
	        ModelLoader.setCustomModelResourceLocation(item, 0
	        		, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	       
	    }
}
