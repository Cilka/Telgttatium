package mod.telgttatium.item;

import net.minecraft.item.ItemPickaxe;

public class BasePickaxe extends ItemPickaxe {
    public BasePickaxe(ToolMaterial material) {
        super(material);
    }

    public BasePickaxe(int maxUses, float efficiency, float attackDamageIn, float attackSpeedIn)
    {
        super(ToolMaterial.DIAMOND);
        // this.toolMaterial = materialIn;
        this.maxStackSize = 1;
        this.setMaxDamage(maxUses);
        this.efficiency = efficiency;
        this.attackDamage = attackDamageIn;
        this.attackSpeed = attackSpeedIn;
       // setHarvestLevel("pickaxe", harvestLevel);
    }
}

