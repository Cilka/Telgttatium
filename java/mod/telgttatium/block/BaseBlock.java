package mod.telgttatium.block;

import mod.telgttatium.Main;

import mod.telgttatium.utils.ModOptions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseBlock extends Block{

	private String blockName;
	private BlockRenderLayer layer;
	private boolean ignoreSimilarity;
	public BaseBlock(String blockName, ModOptions options)
	{
		super(options.getMaterial());
		setSoundType(options.getSound());
		this.blockName = blockName;
		this.layer = options.getLayer();
		this.ignoreSimilarity = options.canIgnoreSimilarity();
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
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
		Block block = iblockstate.getBlock();

		if (this.material == Material.GLASS)
		{
			if (blockState != iblockstate)
			{
				return true;
			}

			if (block == this)
			{
				return false;
			}
		}

		return !this.ignoreSimilarity && block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
