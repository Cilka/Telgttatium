package com.cilka.telgt.init;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import com.cilka.telgt.Main;
import com.cilka.telgt.item.ItemFirstItem;
@ObjectHolder(Main.MODID)
public class ModItems {
public static final ItemFirstItem First_Item = new ItemFirstItem();
}
