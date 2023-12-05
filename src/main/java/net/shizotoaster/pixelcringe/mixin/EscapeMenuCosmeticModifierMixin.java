package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.client.gui.override.escape.cosmetic.EscapeMenuCosmeticModifier;
import net.minecraftforge.client.event.GuiScreenEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EscapeMenuCosmeticModifier.class)
public class EscapeMenuCosmeticModifierMixin {
    @Inject(method = "onPreRender", at = @At("HEAD"), remap = false, cancellable = true)
    public void fuckEscapeMenuModifier(GuiScreenEvent.InitGuiEvent.Post event, CallbackInfo ci) {
        ci.cancel();
    }
}
