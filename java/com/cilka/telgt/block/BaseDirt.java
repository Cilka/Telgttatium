package com.cilka.telgt.block;

import com.cilka.telgt.Main;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BaseDirt extends BlockDirt {
    public BaseDirt (String blockName){
        super();
        setRegistryName(Main.MODID, blockName);
        setTranslationKey(blockName);
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
        net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));
        return plantType == EnumPlantType.Plains ||
                plantType == EnumPlantType.Crop
                ? true : plantType == EnumPlantType.Beach? isNearWater(world,pos): super.canSustainPlant(state,world,pos,direction,plantable);
    }

    private boolean isNearWater(IBlockAccess world, BlockPos pos)
    {
        return (world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.south()).getMaterial() == Material.WATER);
    }
}
