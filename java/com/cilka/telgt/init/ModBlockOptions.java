package com.cilka.telgt.init;

import com.cilka.telgt.block.BlockOptions;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class ModBlockOptions {

	public static final BlockOptions CELTIC_GLASS =  new BlockOptions(Material.GLASS, SoundType.GLASS,Tabs.GLASS,BlockRenderLayer.TRANSLUCENT);
	public static final BlockOptions GRASS =new BlockOptions(Material.GRASS, SoundType.GROUND, Tabs.NATRUAL, BlockRenderLayer.SOLID);
	public static final BlockOptions BRICK = new BlockOptions(Material.ROCK, SoundType.STONE, Tabs.BRICKS, BlockRenderLayer.SOLID);
	public static final BlockOptions DIRT= new BlockOptions(Material.GROUND, SoundType.GROUND, Tabs.NATRUAL, BlockRenderLayer.SOLID);
	public static final BlockOptions STONE= new BlockOptions(Material.ROCK, SoundType.STONE, Tabs.NATRUAL, BlockRenderLayer.SOLID);
	public static final BlockOptions LEAVES= new BlockOptions(Material.PLANTS, SoundType.PLANT, Tabs.NATRUAL, BlockRenderLayer.SOLID);
	public static final BlockOptions WOOL= new BlockOptions(Material.CARPET, SoundType.CLOTH, Tabs.WOOL, BlockRenderLayer.SOLID);
	public static final BlockOptions CERAMIC= new BlockOptions(Material.ROCK, SoundType.STONE, Tabs.CERAMIC, BlockRenderLayer.SOLID);
	public static final BlockOptions CHECKEREDCERAMIC= new BlockOptions(Material.ROCK, SoundType.STONE, Tabs.CHECKERED_CERAMIC, BlockRenderLayer.SOLID);
	public static final BlockOptions NEVOEVO= new BlockOptions(Material.ROCK, SoundType.STONE, Tabs.NEVOEVO, BlockRenderLayer.SOLID);
	public static final BlockOptions RUNES= new BlockOptions(Material.ROCK, SoundType.STONE, Tabs.RUNES, BlockRenderLayer.SOLID);
	public static final BlockOptions WINTER= new BlockOptions(Material.SNOW, SoundType.SNOW, Tabs.NATRUAL, BlockRenderLayer.SOLID);
	public static final BlockOptions SIMPLEWOOD= new BlockOptions(Material.WOOD, SoundType.WOOD, Tabs.SIMPLELIFE, BlockRenderLayer.SOLID);
	public static final BlockOptions NVEGLASS =  new BlockOptions(Material.GLASS, SoundType.GLASS,Tabs.NEVOEVO,BlockRenderLayer.TRANSLUCENT);
	public static final BlockOptions LUJILLKANSES =  new BlockOptions(Material.ROCK, SoundType.STONE,Tabs.LUJILLKANSES,BlockRenderLayer.SOLID);


}
