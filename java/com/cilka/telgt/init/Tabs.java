package com.cilka.telgt.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs {
/*
    public static CreativeTabs BRICKS = new TelTab("brick") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BRICKS[0]);
        }
    };

    public static CreativeTabs NATRUAL = new TelTab("natural") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.DIRT[0]);
        }
    };

    public static CreativeTabs WOOL = new TelTab("carpet_wool") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.WOOL[0]);
        }
    };

    public static CreativeTabs CHECKERED_CERAMIC = new TelTab("checkered_ceramic") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BIGWHITECERAMIC[0]);
        }
    };
    public static CreativeTabs CERAMIC = new TelTab("ceramic") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CERAMIC[0]);
        }
    };

    public static CreativeTabs NEVOEVO = new TelTab("nevo_evolution") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.NEVOEVO[0]);
        }
    };

    public static CreativeTabs RUNES = new TelTab("runes") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CELTICRUNES[0]);
        }
    };

    public static CreativeTabs SIMPLELIFE = new TelTab("simple_life") {
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
    public static CreativeTabs CITYBLOCKS = new TelTab("city_blocks") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CITYBLOCKS[0]);
        }
    };
    public static CreativeTabs SRIDINTARIA = new TelTab("sridintaria") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.SRINDINTARIA[0]);
        }
    };

    public static CreativeTabs GANDECO = new TelTab("gan_deco") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.GANDECO[0]);
        }
    };
    public static CreativeTabs GOLDTAYA = new TelTab("gold_taya") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.GOLDTAYA[0]);
        }
    };
    public static CreativeTabs ICEDECO = new TelTab("ice_deco") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.ICEDECO[0]);
        }
    };
    public static CreativeTabs MOKOIV = new TelTab("mokoiv") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.MOKOIV[0]);
        }
    };
    public static CreativeTabs TUVUCLEIK = new TelTab("tuvu_cleik") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.TUVUCLEIK[0]);
        }
    };
    public static CreativeTabs AGA = new TelTab("aga") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.AGA[0]);
        }
    };
    public static CreativeTabs ANCIENT = new TelTab("ancient") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.ANCIENT[0]);
        }
    };
    public static CreativeTabs CASTLE = new TelTab("castle") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CASTLE[0]);
        }
    };
    public static CreativeTabs TETRI = new TelTab("tetri") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.TETRI[0]);
        }
    };
    public static CreativeTabs TNA = new TelTab("tna") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.TNA[0]);
        }
    };
    public static CreativeTabs NORMAL = new TelTab("normal") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.FLOOR[0]);
        }
    }; public static CreativeTabs TEMPLE = new TelTab("temple") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.TEMPLE[0]);
        }
    };
/*
    public static CreativeTabs FASTFOOD = new TelTab("fast_food") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.FASTFOOD[0]);
        }
    };
    public static CreativeTabs CANDY = new TelTab("candy") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CANDY[0]);
        }
    };
    public static CreativeTabs FOOD = new TelTab("food") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.FOOD[0]);
        }
    };
     public static CreativeTabs FENCES = new TelTab("fences") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.KUNKASIE[0]);
        }
    };
    public static CreativeTabs TOOLS = new TelTab("tools") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.KUNKASIE[0]);
        }
    };*/
}
