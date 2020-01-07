package mod.telgttatium.block;

import mod.telgttatium.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;

public class TieredOre extends BlockOre {
    private static final PropertyBool FINALSTEP = PropertyBool.create("final_step");
    private String ore;
    private int dropAmount;
    private boolean finalStep;

    public TieredOre(String ore,boolean finalStep, int dropAmount, int harvestLevel)
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(FINALSTEP, finalStep));
        this.ore =  ore;
        this.dropAmount = dropAmount;
        this.finalStep = finalStep;
        this.setHarvestLevel("pickaxe",harvestLevel);
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (finalStep){
            return Utils.items.get(ore);
        }
        return null;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return dropAmount;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if(!finalStep)
        {
            //finalStep =  true;
           // worldIn.setBlockState(pos,state.withProperty(FINALSTEP,finalStep));
            worldIn.setBlockState(pos, Utils.blocks.get(this.getLocalizedName()
                    .substring(this.getLocalizedName().indexOf(".")+1,this.getLocalizedName().lastIndexOf(".") )
                    + "_final_step").getDefaultState());

        }


    }

    private void spawnDrops(World worldIn, BlockPos pos, ItemStack stack, int iterations){
        for(int i  =0; i < iterations; i++)
        {
            Block.spawnAsEntity(worldIn, pos, stack);
        }
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FINALSTEP});
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

}
