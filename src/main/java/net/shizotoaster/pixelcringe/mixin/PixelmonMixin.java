package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Pixelmon.class)
public class PixelmonMixin {
    @Inject(method = "onClientLoaded", at = @At("HEAD"), remap = false, cancellable = true)
    private static void pixelcringe$fuckPixelmonIcon(FMLClientSetupEvent event, CallbackInfo ci) {
        if (PixelCringeConfig.PIXELMON_ICON_PATCH.get()) ci.cancel();
    }
}
