package mod.telgttatium.block;

import mod.telgttatium.utils.Utils;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class TelOre extends BlockOre {
    String ore;
    int dropAmount;
    public TelOre(String ore, int dropAmount, int harvestLevel)
    {
       this.ore =  ore;
       this.dropAmount = dropAmount;
       this.setHarvestLevel("pickaxe", harvestLevel);
    }
    @Override
    public int quantityDropped(Random random)
    {
        return dropAmount;
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Utils.items.get(ore);
    }
}
