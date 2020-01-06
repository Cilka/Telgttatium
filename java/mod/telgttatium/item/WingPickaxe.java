package mod.telgttatium.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class WingPickaxe extends BasePickaxe {
    public WingPickaxe(ToolMaterial material) {
        super(material);
    }

    public WingPickaxe(int maxUses, int harvestLevel, float efficiency, float attackDamageIn, float attackSpeedIn){
        super(maxUses, harvestLevel, efficiency, attackDamageIn, attackSpeedIn);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if(handIn == EnumHand.OFF_HAND)
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
        }
        ItemStack pickax = playerIn.getHeldItem(handIn);

        switch(pickax.getDisplayName().substring(pickax.getDisplayName().indexOf('.')+1, pickax.getDisplayName().lastIndexOf('.'))){
            case "dovah_wing_pickaxe":{
                playerIn.motionY += .34;
                break;
            }
            case "ghi_wing_pickaxe":{
                playerIn.motionY += .36;
            break;
            }
            case "lejinka_wing_pickaxe":{
                playerIn.motionY += .375;
                break;
            }
            case "uonka_wing_pickaxe":{
                playerIn.motionY += .39;
                break;
            }
            case "yuhog_wing_pickaxe":{
                playerIn.motionY += .40;
                break;
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if(isSelected && entityIn instanceof EntityPlayer &&
                (((EntityPlayer)entityIn).getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof WingPickaxe ||
                        ((EntityPlayer)entityIn).getHeldItem(EnumHand.OFF_HAND).getItem() instanceof WingPickaxe))
        {
            ((EntityPlayer)entityIn).fallDistance = 1;

        }
    }
}
