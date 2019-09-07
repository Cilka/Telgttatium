package com.cilka.telgt.block;



import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockFirstBlock extends Block {
	public BlockFirstBlock() {
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.MISC);
		setSoundType(SoundType.STONE);
	}
}
