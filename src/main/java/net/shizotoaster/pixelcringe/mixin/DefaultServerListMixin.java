package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.client.DefaultServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultServerList.class)
public class DefaultServerListMixin {
    @Inject(method = "tryFetchDefaultServers(Ljava/lang/Runnable;)V", at = @At("HEAD"), remap = false, cancellable = true)
    private static void fuckServerListModifications(Runnable onComplete, CallbackInfo ci) {
        ci.cancel();
    }
}
