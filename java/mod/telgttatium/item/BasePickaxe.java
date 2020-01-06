package mod.telgttatium.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class BasePickaxe extends ItemPickaxe {
    private int harvestLevel;
    public BasePickaxe(ToolMaterial material) {
        super(material);
    }

    public BasePickaxe(int maxUses, int harvestLevel, float efficiency, float attackDamageIn, float attackSpeedIn)
    {
        super(ToolMaterial.DIAMOND);
        this.maxStackSize = 1;
        this.setMaxDamage(maxUses);
        this.efficiency = efficiency;
        this.attackDamage = attackDamageIn;
        this.attackSpeed = attackSpeedIn;
        this.harvestLevel = harvestLevel;
        setHarvestLevel("pickaxe", harvestLevel);
    }
    @Override
    public boolean canHarvestBlock(IBlockState block)
    {
        return block.getBlock().getHarvestLevel(block) <= this.harvestLevel;
    }
    /*
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
         if( "kifavara_frozen_pickaxe".equalsIgnoreCase( stack.getItem().getUnlocalizedNameInefficiently(stack))){
          //  target.addPotionEffect();
    }
        return super.hitEntity(stack, target,attacker);
    }*/
}

