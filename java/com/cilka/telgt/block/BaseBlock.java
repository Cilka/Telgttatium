package com.cilka.telgt.block;

import com.cilka.telgt.Main;

import com.cilka.telgt.utils.ModOptions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class BaseBlock extends Block{

	private String blockName;
	private BlockRenderLayer layer;

	public BaseBlock(String blockName, ModOptions options)
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
