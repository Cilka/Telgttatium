package com.cilka.telgt.init;
import com.cilka.telgt.Utils;
import com.cilka.telgt.block.BaseBlock;
import com.cilka.telgt.block.BaseGrassBlock;


//@ObjectHolder(Main.MODID)
public class ModBlocks {

	
//public static final BlockFirstBlock First_Block = new BlockFirstBlock();
	public static final BaseBlock [] BRICKS = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("brick"), Tabs.BRICKS);
	public static final BaseBlock [] DIRT = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("biome_dirt"), Tabs.NATRUAL);
	public static final BaseBlock [] STONE = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("biome_stone"), Tabs.NATRUAL);
	public static final BaseBlock [] LEAVES = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("biome_tree_leaves"), Tabs.NATRUAL);
	public static final BaseBlock [] WOOL = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("carpet_wool"), Tabs.WOOL);
	public static final BaseBlock [] CERAMIC = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("ceramic"), Tabs.CERAMIC);
	public static final BaseBlock [] BIGBLACKCERAMIC = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("ceramic.big_black_block_floor"), Tabs.CHECKERED_CERAMIC);
	public static final BaseBlock [] BIGWHITECERAMIC = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("ceramic.big_white_block_floor"), Tabs.CHECKERED_CERAMIC);
	public static final BaseBlock [] BLACKCERAMIC = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("ceramic.black_block_floor"), Tabs.CHECKERED_CERAMIC);
	public static final BaseBlock [] WHITECERAMIC = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("ceramic.white_block_floor"), Tabs.CHECKERED_CERAMIC);
	public static final BaseBlock [] NEVOEVO = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("nevo_evolution"), Tabs.NEVOEVO);
	public static final BaseBlock [] BIONICSTAINED = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("nevo_evolution.bionic_stained"), Tabs.NEVOEVO);
	public static final BaseBlock [] NVESTAINED = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("nevo_evolution.nve_stained"), Tabs.NEVOEVO);
	public static final BaseBlock [] NVETCHTILES = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("nevo_evolution.nve_tch_tiles"), Tabs.NEVOEVO);
	public static final BaseBlock [] RUNES = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("runes"), Tabs.RUNES);
	public static final BaseBlock [] CELTICRUNES = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("runes.celtic_tile"), Tabs.RUNES);
	public static final BaseBlock [] VOLCANIC = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("volcanic"), Tabs.NATRUAL);
	public static final BaseBlock [] WINTER = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("winter"), Tabs.NATRUAL);
	public static final BaseBlock [] WOODFLOOR = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("wood.floor"), Tabs.SIMPLELIFE);
	public static final BaseBlock [] WOODWALL = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("wood.wall"), Tabs.SIMPLELIFE);	
	public static final BaseBlock [] CELTICGLASS = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("glass.celtic", ModBlockOptions.CELTIC_GLASS), Tabs.GLASS);
	public static final BaseBlock [] NVEGLASS = Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("glass.nve", ModBlockOptions.CELTIC_GLASS), Tabs.GLASS);
	public static final BaseBlock [] GRASS =  Utils.AddBlocksToTab(Utils.GenerateBlocksFromTextureFolder("biome_grass", ModBlockOptions.GRASS, BaseGrassBlock.class), Tabs.NATRUAL);
}
