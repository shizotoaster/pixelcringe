package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.api.config.GeneralConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GeneralConfig.class)
public class GeneralConfigMixin {
    @Inject(method = "isUseDiscordRichPresence", at = @At("HEAD"), remap = false, cancellable = true)
    public void fuckYouDiscordPresence(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
