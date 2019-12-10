package com.cilka.telgt.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class ModOptions {
    private Material Material;
    private SoundType Sound;
    private BlockRenderLayer Layer;
    private boolean dropSelf;
    private boolean framed;
    public boolean canDropSelf() {
        return dropSelf;
    }

    public boolean isFramed() {
        return framed;
    }


    public ModOptions(Material material, SoundType sound, BlockRenderLayer layer){
        Material = material;
        Sound = sound;
        Layer = layer;
    }

    public net.minecraft.block.material.Material getMaterial() {
        return Material;
    }

    public SoundType getSound() {
        return Sound;
    }

    public BlockRenderLayer getLayer() {
        return Layer;
    }
}
