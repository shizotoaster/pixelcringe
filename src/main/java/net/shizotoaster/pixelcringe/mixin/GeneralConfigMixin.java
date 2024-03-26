package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.api.config.GeneralConfig;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GeneralConfig.class)
public class GeneralConfigMixin {
    @Inject(method = "isUseDiscordRichPresence", at = @At("HEAD"), cancellable = true, remap = false)
    private void pixelCringe$fuckDiscordRPC(CallbackInfoReturnable<Boolean> cir) {
        if (PixelCringeConfig.FORCE_DISABLE_RPC.get()) cir.setReturnValue(false);
    }
}
