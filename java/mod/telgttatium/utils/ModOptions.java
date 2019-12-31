package mod.telgttatium.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class ModOptions {
    private Material Material;
    private SoundType Sound;
    private BlockRenderLayer Layer;
    private boolean dropSelf;
    private boolean framed;
    private boolean ignoreSimularity;
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
        ignoreSimularity = false;
    }

    public ModOptions(Material material, SoundType sound, BlockRenderLayer layer, Boolean ignoreSimularity){
        Material = material;
        Sound = sound;
        Layer = layer;
        this.ignoreSimularity = ignoreSimularity;
    }

    public boolean canIgnoreSimilarity()
    {
        return ignoreSimularity;
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
