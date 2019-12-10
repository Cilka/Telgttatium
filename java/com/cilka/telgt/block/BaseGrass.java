package com.cilka.telgt.block;

import com.cilka.telgt.Main;
import com.cilka.telgt.utils.ModOptions;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BaseGrass extends BlockGrass  {
    private String blockName;
    private BlockRenderLayer layer;
    public BaseGrass(String blockName, ModOptions options) {
        setSoundType(options.getSound());
        this.blockName = blockName;
        this.layer = options.getLayer();

        SetRegistrationFromFile();
    }
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return layer;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {

        return layer != null ? layer.equals(BlockRenderLayer.SOLID) : super.isOpaqueCube(state);
    }
    private void SetRegistrationFromFile()
    {
        setRegistryName(Main.MODID, blockName);
        setTranslationKey(blockName);
    }

}
