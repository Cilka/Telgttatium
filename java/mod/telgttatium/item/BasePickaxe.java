package mod.telgttatium.item;

import mod.telgttatium.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BasePickaxe extends ItemPickaxe {
    private int harvestLevel;
    private String name;
    private static  Random rand =  new Random();
    public BasePickaxe(ToolMaterial material) {
        super(material);
    }

    public BasePickaxe(String name, int maxUses, int harvestLevel, float efficiency, float attackDamageIn, float attackSpeedIn)
    {
        super(ToolMaterial.DIAMOND);
        this.maxStackSize = 1;
        this.setMaxDamage(maxUses);
        this.efficiency = efficiency;
        this.attackDamage = attackDamageIn;
        this.attackSpeed = attackSpeedIn;
        this.harvestLevel = harvestLevel;
        setHarvestLevel("pickaxe", harvestLevel);
        this.name = name;
        this.setRegistryName(Main.MODID,name);
        this.setTranslationKey(name);
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

