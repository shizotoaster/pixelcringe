package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.client.gui.override.main.MainMenuModifier;
import net.minecraftforge.client.event.GuiScreenEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MainMenuModifier.class)
public class MainMenuModifierMixin {
    @Inject(method = "onPreRender", at = @At("HEAD"), remap = false, cancellable = true)
    public void fuckMainMenuModifier(GuiScreenEvent.InitGuiEvent.Post event, CallbackInfo ci) {
        ci.cancel();
    }
}
