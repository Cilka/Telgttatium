package com.cilka.telgt.init;
import com.cilka.telgt.utils.Utils;
import net.minecraft.item.Item;

public class ModItems {
//public static final ItemFirstItem First_Item = new ItemFirstItem();
public static final Item[] CANDY = Utils.GenerateItemsFromTextureFolder("candies", null, null);
public static final Item[] FASTFOOD=Utils.GenerateItemsFromTextureFolder("fast_food", null, null);
public static final Item[] FOOD=Utils.GenerateItemsFromTextureFolder("food", null, null);
}
