package mod.telgttatium.utils.block;

import mod.telgttatium.Main;
import mod.telgttatium.utils.ModOptions;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;

public class BaseColumn extends BlockRotatedPillar {
    protected BaseColumn(Material materialIn) {
        super(materialIn);
    }



    private String blockName;
    private BlockRenderLayer layer;
    public BaseColumn(String blockName) {

        super(Material.ROCK);
        setCreativeTab(CreativeTabs.MISC);
        setSoundType(SoundType.CLOTH);
        this.blockName = blockName;
        SetRegistrationFromFile();
    }

    public BaseColumn(String blockName, ModOptions options)
    {
        super(options.getMaterial());
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
