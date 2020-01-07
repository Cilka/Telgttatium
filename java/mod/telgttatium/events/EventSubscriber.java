package mod.telgttatium.events;
import mod.telgttatium.Main;
import mod.telgttatium.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
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

@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
public static void onSrindintariaPickaxeHarvest(BlockEvent.BreakEvent event)
{
	Item pickaxe  = event.getPlayer().getHeldItemMainhand().getItem();
	Block  block = event.getState().getBlock();
	World world =  event.getWorld();
	Item drop = block.getItemDropped(event.getState(),world.rand, 0);
	int count =0;
	if(block instanceof BlockOre)
	{
		switch (pickaxe.getRegistryName().getPath()) {
			case "srindintaria_athemyst_upgrade_pickaxe": {
				count = 2;
				//  spawnDrops(worldIn, pos, drop, 2 );

				if(!"ruby".equalsIgnoreCase(drop.getRegistryName().getNamespace()))
				{
					count += world.rand.nextInt(6);
					// spawnDrops(worldIn, pos, drop, rand.nextInt(6) );
				}
				break;
			}
			case "srindintaria_emerald_upgrade_pickaxe": {
				if("minecraft".equalsIgnoreCase(drop.getRegistryName().getNamespace()) || "emerald".equalsIgnoreCase(drop.getRegistryName().getPath()))
				{
					count =3;
					// spawnDrops(worldIn, pos, drop,3);
				}
				break;
			}
			case "srindintaria_ruby_upgrade_pickaxe": {
				if(!"ruby".equalsIgnoreCase(drop.getRegistryName().getPath()))
				{
					count = 4;
					// spawnDrops(worldIn, pos, drop, 4 );
				}
				break;
			}
		}
		for(int i =0; i < count; i++)
		{
			Block.spawnAsEntity(world, event.getPos(),new ItemStack(drop));
		}
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
