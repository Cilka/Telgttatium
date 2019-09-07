package com.cilka.telgt.tabs;

import  net.minecraft.creativetab.CreativeTabs;
import com.cilka.telgt.Main;
import com.cilka.telgt.init.ModItems;
 
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class TutorialTab extends CreativeTabs {

	public TutorialTab() {
		super(Main.MODID);
		// TODO Auto-generated constructor stub
	}


	

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.First_Item);
	}
}
