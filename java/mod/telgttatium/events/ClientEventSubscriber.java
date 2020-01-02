package mod.telgttatium.events;

import mod.telgttatium.Main;

import mod.telgttatium.utils.Utils;
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

	  		for(int i : Utils.blockOrder.keySet())
			{
				registerModel(Item.getItemFromBlock(Utils.blocks.get(Utils.blockOrder.get(i))));
			}
	  		for(int i : Utils.itemOrder.keySet())
			{
				registerModel(Utils.items.get(Utils.itemOrder.get(i)));
			}

	  }

	    private static void registerModel(Item item) {
	    
	        ModelLoader.setCustomModelResourceLocation(item, 0
	        		, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	       
	    }
}
