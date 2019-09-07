package com.cilka.telgt.init;

import com.cilka.telgt.block.BlockOptions;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class ModBlockOptions {

	public static final BlockOptions CELTIC_GLASS =  new BlockOptions(Material.GLASS,
			SoundType.GLASS,Tabs.GLASS,BlockRenderLayer.TRANSLUCENT);
	public static final BlockOptions GRASS =new BlockOptions(Material.GRASS, SoundType.GROUND, Tabs.NATRUAL, BlockRenderLayer.SOLID);
}
