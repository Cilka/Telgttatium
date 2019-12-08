package com.cilka.telgt.item;
import net.minecraft.creativetab.CreativeTabs;
public class ItemOptions {
    private CreativeTabs tab;
    public ItemOptions(CreativeTabs tab)
    {
        this.tab = tab;
    }
    public CreativeTabs getTab()
    {
        return tab;
    }
}
