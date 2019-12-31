package mod.telgttatium;
import mod.telgttatium.utils.Utils;
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

		for(int i : Utils.blockOrder.keySet())
		{
			event.getRegistry().register(ConvertToItemBlock(Utils.blocks.get(Utils.blockOrder.get(i))));

		}
		for(int i : Utils.itemOrder.keySet())
		{
			event.getRegistry().register(Utils.items.get(Utils.itemOrder.get(i)));

		}
	}
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {

		for(int i : Utils.blockOrder.keySet() ){
			event.getRegistry().register(Utils.blocks.get(Utils.blockOrder.get(i)));

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
