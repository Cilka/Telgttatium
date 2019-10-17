package com.cilka.telgt.block;

import com.cilka.telgt.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BasePane extends BlockPane {
    public static final PropertyBool Down               = PropertyBool.create("down");
    public static final PropertyBool DownLeft           = PropertyBool.create("down_left");
    public static final PropertyBool DownRight          = PropertyBool.create("down_right");
    public static final PropertyBool DownWalled         = PropertyBool.create("down_walled");
    public static final PropertyBool Center             = PropertyBool.create("middle");
    public static final PropertyBool CenterFull         = PropertyBool.create("full");
    public static final PropertyBool HorizontalMiddle   = PropertyBool.create("horizontal_middle");
    public static final PropertyBool Left               = PropertyBool.create("left");
    public static final PropertyBool Right              = PropertyBool.create("right");
    public static final PropertyBool VerticalMiddle     = PropertyBool.create("vertical_middle");
    public static final PropertyBool TopLeft            = PropertyBool.create("top_left");
    public static final PropertyBool TopRight           = PropertyBool.create("top_right");
    public static final PropertyBool TopWalled          = PropertyBool.create("top_single");
    public static final PropertyBool RightWalled        = PropertyBool.create("right_single");
    public static final PropertyBool LeftWalled         = PropertyBool.create("left_single");
    public static final PropertyBool Top                = PropertyBool.create("top");
    protected BasePane(Material materialIn, boolean canDrop) {
        super(materialIn, canDrop);
    }
    private boolean isFramed;
    public BasePane(String blockName, BlockOptions options)
    {
        super(options.GetMaterial(), options.CanDropSelf());
        setRegistryName(Main.MODID, blockName);
        setTranslationKey(blockName);
        isFramed = options.IsFramed();
    }
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if(isFramed) {
            Block up = worldIn.getBlockState(pos.up()).getBlock();
            Block down = worldIn.getBlockState(pos.down()).getBlock();
            Block left = worldIn.getBlockState(pos.west()).getBlock();
            Block right = worldIn.getBlockState(pos.east()).getBlock();
            SetPosition(up, down, left, right, state);
        }
      super.onBlockAdded(worldIn, pos, state);

    }
    private void SetPosition(Block up, Block down, Block left, Block right, IBlockState state)
    {
        state.withProperty(CenterFull, Boolean.valueOf(exists(up) && exists(down) && exists(left) && exists(right) && !isPane(up)&& !isPane(down)&& !isPane(left)&& !isPane(right)))
             .withProperty(Center,     Boolean.valueOf(exists(up) && exists(down) && exists(left) && exists(right) && isPane(up)&& isPane(down)&& isPane(left)&& isPane(right)))
             .withProperty(VerticalMiddle, Boolean.valueOf(!exists(up) && !exists(down) && exists(left) && exists(right) && !isPane(left)&& !isPane(right)))
             .withProperty(HorizontalMiddle, Boolean.valueOf(exists(up) && exists(down) && !exists(left) && !exists(right) && !isPane(up)&& !isPane(down)))
             .withProperty(TopWalled, Boolean.valueOf(exists(up) && !exists(down) && exists(left) && exists(right) && !isPane(up)&& !isPane(left)&& !isPane(right)))
             .withProperty(DownWalled, Boolean.valueOf(!exists(up) && exists(down) && exists(left) && exists(right)&& !isPane(down)&& !isPane(left)&& !isPane(right)))
             .withProperty(RightWalled, Boolean.valueOf(exists(up) && exists(down) && !exists(left) && exists(right) && !isPane(up)&& !isPane(down)&&  !isPane(right)))
             .withProperty(LeftWalled, Boolean.valueOf(exists(up) && exists(down) && exists(left) && !exists(right) && !isPane(up)&& !isPane(down)&& !isPane(left)))
             .withProperty(DownLeft, Boolean.valueOf(!exists(up) && exists(down) && exists(left) && !exists(right) && !isPane(down)&& !isPane(left)))
             .withProperty(DownRight, Boolean.valueOf(!exists(up) && exists(down) && !exists(left) && exists(right) && !isPane(down)&& !isPane(right)))
             .withProperty(TopLeft,  Boolean.valueOf(exists(up) && !exists(down) && exists(left) && !exists(right) && !isPane(up)&& !isPane(left)))
             .withProperty(TopRight, Boolean.valueOf(exists(up) && !exists(down) && !exists(left) && exists(right) && !isPane(up)&& !isPane(right)))
             .withProperty(Top, Boolean.valueOf(exists(up) && !exists(down) && !exists(left) && !exists(right) && !isPane(up)))
             .withProperty(Down, Boolean.valueOf(!exists(up) && exists(down) && !exists(left) && !exists(right) && !isPane(down)))
             .withProperty(Left, Boolean.valueOf(!exists(up) && !exists(down) && exists(left) && !exists(right) && !isPane(left)))
             .withProperty(Right, Boolean.valueOf(!exists(up) && !exists(down) && !exists(left) && exists(right) && !isPane(right)));
    }
    private boolean exists(Block block)
    {
        return block != null && !(block instanceof BlockAir);
    }
    private boolean isPane(Block block)
    {
        return block instanceof BasePane || block instanceof  BlockPane;
    }
}
