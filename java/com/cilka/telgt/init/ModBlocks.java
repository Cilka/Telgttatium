package com.cilka.telgt.init;
import com.cilka.telgt.Utils;
import com.cilka.telgt.block.BaseBlock;
import com.cilka.telgt.block.BaseGrassBlock;


//@ObjectHolder(Main.MODID)
public class ModBlocks {

	
//public static final BlockFirstBlock First_Block = new BlockFirstBlock();
	public static final BaseBlock [] BRICKS = Utils.GenerateBlocksFromTextureFolder("brick", ModBlockOptions.BRICK);
	public static final BaseBlock [] DIRT = Utils.GenerateBlocksFromTextureFolder("biome_dirt", ModBlockOptions.DIRT);
	public static final BaseBlock [] STONE = Utils.GenerateBlocksFromTextureFolder("biome_stone", ModBlockOptions.STONE);
	public static final BaseBlock [] LEAVES = Utils.GenerateBlocksFromTextureFolder("biome_tree_leaves", ModBlockOptions.LEAVES);
	public static final BaseBlock [] WOOL = Utils.GenerateBlocksFromTextureFolder("carpet_wool", ModBlockOptions.WOOL);
	public static final BaseBlock [] CERAMIC = Utils.GenerateBlocksFromTextureFolder("ceramic", ModBlockOptions.CERAMIC);
	public static final BaseBlock [] BIGBLACKCERAMIC = Utils.GenerateBlocksFromTextureFolder("ceramic.big_black_block_floor", ModBlockOptions.CHECKEREDCERAMIC);
	public static final BaseBlock [] BIGWHITECERAMIC = Utils.GenerateBlocksFromTextureFolder("ceramic.big_white_block_floor", ModBlockOptions.CHECKEREDCERAMIC);
	public static final BaseBlock [] BLACKCERAMIC = Utils.GenerateBlocksFromTextureFolder("ceramic.black_block_floor", ModBlockOptions.CHECKEREDCERAMIC);
	public static final BaseBlock [] WHITECERAMIC = Utils.GenerateBlocksFromTextureFolder("ceramic.white_block_floor", ModBlockOptions.CHECKEREDCERAMIC);
	public static final BaseBlock [] NEVOEVO = Utils.GenerateBlocksFromTextureFolder("nevo_evolution",ModBlockOptions.NEVOEVO);
	public static final BaseBlock [] BIONICSTAINED = Utils.GenerateBlocksFromTextureFolder("nevo_evolution.bionic_stained",ModBlockOptions.NEVOEVO);
	public static final BaseBlock [] NVESTAINED = Utils.GenerateBlocksFromTextureFolder("nevo_evolution.nve_stained",ModBlockOptions.NEVOEVO);
	public static final BaseBlock [] NVETCHTILES = Utils.GenerateBlocksFromTextureFolder("nevo_evolution.nve_tch_tiles", ModBlockOptions.NEVOEVO);
	public static final BaseBlock [] RUNES = Utils.GenerateBlocksFromTextureFolder("runes",ModBlockOptions.RUNES);
	public static final BaseBlock [] CELTICRUNES = Utils.GenerateBlocksFromTextureFolder("runes.celtic_tile", ModBlockOptions.CERAMIC);
	public static final BaseBlock [] VOLCANIC = Utils.GenerateBlocksFromTextureFolder("volcanic",ModBlockOptions.STONE);
	public static final BaseBlock [] WINTER = Utils.GenerateBlocksFromTextureFolder("winter", ModBlockOptions.WINTER);
	public static final BaseBlock [] WOODFLOOR = Utils.GenerateBlocksFromTextureFolder("wood.floor", ModBlockOptions.SIMPLEWOOD);
	public static final BaseBlock [] WOODWALL = Utils.GenerateBlocksFromTextureFolder("wood.wall", ModBlockOptions.SIMPLEWOOD);
	public static final BaseBlock [] CELTICGLASS = Utils.GenerateBlocksFromTextureFolder("glass.celtic", ModBlockOptions.CELTIC_GLASS);
	public static final BaseBlock [] NVEGLASS = Utils.GenerateBlocksFromTextureFolder("glass.nve", ModBlockOptions.NVEGLASS);
	public static final BaseBlock [] GRASS =  Utils.GenerateBlocksFromTextureFolder("biome_grass", ModBlockOptions.GRASS, BaseGrassBlock.class);
	public static final BaseBlock [] NORMALGLASS = Utils.GenerateBlocksFromTextureFolder("glass.glass_color", ModBlockOptions.CELTIC_GLASS);
	public static final BaseBlock [] CLEURSARDI = Utils.GenerateBlocksFromTextureFolder("lujill_kanses.cleursardi", ModBlockOptions.LUJILLKANSES);
	public static final BaseBlock [] FIVHYNA = Utils.GenerateBlocksFromTextureFolder("lujill_kanses.fivhyna", ModBlockOptions.LUJILLKANSES);
	public static final BaseBlock [] KUHUNO = Utils.GenerateBlocksFromTextureFolder("lujill_kanses.kuhuno", ModBlockOptions.LUJILLKANSES);
	public static final BaseBlock [] KUNKASIE = Utils.GenerateBlocksFromTextureFolder("lujill_kanses.kunkasie", ModBlockOptions.LUJILLKANSES);
	public static final BaseBlock [] SENAANTI = Utils.GenerateBlocksFromTextureFolder("lujill_kanses.senaati", ModBlockOptions.LUJILLKANSES);
	public static final BaseBlock [] SIMPLEGLASSPANEFRAME = Utils.GenerateBlocksFromTextureFolder("glass.simple_life_glass_frame", ModBlockOptions.SIMPLEGLASSPANEFRAME);
	public static final BaseBlock [] CITYBLOCKS = Utils.GenerateBlocksFromTextureFolder("city_blocks", ModBlockOptions.CITYBLOCK);
	public static final BaseBlock [] ARTGRASS =Utils.GenerateBlocksFromTextureFolder("artifical_grass", ModBlockOptions.GRASS);
	public static final BaseBlock [] GOLDTAYA =  Utils.GenerateBlocksFromTextureFolder("gold_taya", ModBlockOptions.GOLDTAYA);
	public static final BaseBlock [] TUVUCLEIK =  Utils.GenerateBlocksFromTextureFolder("tuvu_cleik", ModBlockOptions.TUVUCLEIK);
	public static final BaseBlock [] SRINDINTARIA =  Utils.GenerateBlocksFromTextureFolder("srindintaria", ModBlockOptions.SRINDINTARIA);
	public static final BaseBlock [] SIMPLELIFE =  Utils.GenerateBlocksFromTextureFolder("simple_life", ModBlockOptions.SIMPLELIFE);
	public static final BaseBlock [] MOKOIV =  Utils.GenerateBlocksFromTextureFolder("mokoiv", ModBlockOptions.MOKOIV);
	public static final BaseBlock [] ICEDECO =  Utils.GenerateBlocksFromTextureFolder("ice_deco", ModBlockOptions.ICEDECO);
	public static final BaseBlock [] GANDECO =  Utils.GenerateBlocksFromTextureFolder("gan_deco", ModBlockOptions.GANDECO);

}
