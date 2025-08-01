package net.shizotoaster.pixelcringe;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;

@Mod("pixelcringe")
public class PixelCringe {
    public static String MOD_ID = "pixelcringe";

    public PixelCringe(ModContainer container) {
        container.registerConfig(ModConfig.Type.STARTUP, PixelCringeConfig.SPEC);
    }
}
