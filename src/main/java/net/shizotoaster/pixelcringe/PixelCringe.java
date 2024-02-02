package net.shizotoaster.pixelcringe;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;

@Mod("pixelcringe")
public class PixelCringe {
    public PixelCringe() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PixelCringeConfig.SPEC);
    }
}
