package com.cilka.telgt.block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
public class BlockOptions {

	private Material Material;
	private SoundType Sound;
	private CreativeTabs Tab;
	private BlockRenderLayer Layer;
	public BlockOptions(Material mat, SoundType sound, CreativeTabs tab, BlockRenderLayer layer)
	{
		this.Material =  mat;
		this.Sound = sound;
		this.Tab = tab;
		this.Layer =  layer;
	}
	
	public Material GetMaterial()
	{
		 return Material;
	}
	public SoundType GetSound()
	{
		 return Sound;
	}
	public CreativeTabs GetTab()
	{
		return Tab;
	}
	public BlockRenderLayer GetLayer()
	{
		return Layer;
	}
}
