package mod.telgttatium.item;

import mod.telgttatium.entity.AI.AIFireballAttack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Staff extends Item {


   @Override
   public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
   {
       if(handIn == EnumHand.OFF_HAND)
       {
           return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
       }
       EntityAITasks targetTasks = new EntityAITasks(worldIn.profiler);
       ItemStack item = playerIn.getHeldItem(handIn);

       switch(item.getDisplayName().substring(item.getDisplayName().indexOf('.')+1, item.getDisplayName().lastIndexOf('.'))) {
           case "gengashesh_fire_staff":{
               targetTasks.addTask(1, new AIFireballAttack(playerIn));
               break;
           }
           case "gengashesh_ice_staff":{
                break;
           }
           case "gengashesh_water_staff":{
                break;
           }
           case "kuh_earth_staff":{
                break;
           }
       }
       targetTasks.onUpdateTasks();
           return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
   }
}
