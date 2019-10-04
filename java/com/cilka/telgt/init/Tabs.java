package com.cilka.telgt.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs{

	public static CreativeTabs BRICKS = new TelTab("brick"){
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.BRICKS[0]);
		}
	};
	
	public static CreativeTabs NATRUAL =  new TelTab("natural") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.DIRT[0]);
		}
	};
	
	public static CreativeTabs WOOL =  new TelTab("carpet_wool") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.WOOL[0]);
		}
	};
	
	public static CreativeTabs CHECKERED_CERAMIC =  new TelTab("checkered_ceramic") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.BIGWHITECERAMIC[0]);
		}
	};
	public static CreativeTabs CERAMIC =  new TelTab("ceramic") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.CERAMIC[0]);
		}
	};
	
	public static CreativeTabs NEVOEVO =  new TelTab("nevo_evolution") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.NEVOEVO[0]);
		}
	};

	public static CreativeTabs RUNES =  new TelTab("runes") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.CELTICRUNES[0]);
		}
	};
	public static CreativeTabs SIMPLELIFE =  new TelTab("simple_life") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.WOODWALL[0]);
		}
	};
	public static CreativeTabs GLASS = new TelTab("glass") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.CELTICGLASS[0]);
		}
	};
	public static CreativeTabs LUJILLKANSES = new TelTab("lujillkanses") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.KUNKASIE[0]);
		}
	};
}
