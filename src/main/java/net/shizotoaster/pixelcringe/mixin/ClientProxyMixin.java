package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.client.ClientProxy;
import net.minecraft.client.util.Icons;
import net.minecraft.client.util.Window;
import net.minecraft.resource.ResourcePack;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientProxy.class)
public class ClientProxyMixin {
    @Inject(method = "setIcon", at = @At("HEAD"), cancellable = true, remap = false)
    private static void pixelcringe$fuckPixelmonIcon(Window window, ResourcePack resources, Icons iconSet, CallbackInfo ci) {
        if (PixelCringeConfig.PIXELMON_ICON_PATCH.get()) ci.cancel();
    }
}
