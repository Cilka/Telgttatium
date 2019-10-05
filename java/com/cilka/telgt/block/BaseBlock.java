package com.cilka.telgt.block;

import com.cilka.telgt.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;

public class BaseBlock extends Block {

	private String blockName;
	private BlockRenderLayer layer;
	public BaseBlock(String blockName) {
		
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.MISC);
		setSoundType(SoundType.CLOTH);
		this.blockName = blockName;
		SetRegistrationFromFile();
	}
	
	public BaseBlock(String blockName, BlockOptions options)
	{
		super(options.GetMaterial());
		setCreativeTab(options.GetTab());
		setSoundType(options.GetSound());
		this.blockName = blockName;
		this.layer = options.GetLayer();

		SetRegistrationFromFile();
	}
	public String GetBlockName()
	{
		return blockName;
	
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
