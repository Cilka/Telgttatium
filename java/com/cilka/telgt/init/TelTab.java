package com.cilka.telgt.init;

import com.cilka.telgt.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TelTab  extends CreativeTabs{

	public TelTab(String tabName) {
		super(Main.MODID + "."+tabName);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return null;
	}
}
