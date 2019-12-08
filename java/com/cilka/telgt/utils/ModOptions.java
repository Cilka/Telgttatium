package com.cilka.telgt.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class ModOptions {
    private Material Material;
    private SoundType Sound;
    private BlockRenderLayer Layer;

    public ModOptions(Material material, SoundType sound, BlockRenderLayer layer){
        Material = material;
        Sound = sound;
        Layer = layer;
    }
}
