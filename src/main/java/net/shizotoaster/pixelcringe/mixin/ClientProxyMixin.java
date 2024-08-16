package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.client.ClientProxy;
import net.minecraft.client.util.Window;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.InputStream;

@Mixin(ClientProxy.class)
public class ClientProxyMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;setIcon(Ljava/io/InputStream;Ljava/io/InputStream;)V"))
    private static void pixelcringe$fuckPixelmonIcon(Window instance, InputStream intbuffer1, InputStream intbuffer2) {
        if (PixelCringeConfig.PIXELMON_ICON_PATCH.get()) return;
    }
}
