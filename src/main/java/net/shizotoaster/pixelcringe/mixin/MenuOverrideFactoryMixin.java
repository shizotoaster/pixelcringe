package net.shizotoaster.pixelcringe.mixin;

import com.pixelmonmod.pixelmon.client.gui.override.MenuOverrideFactory;
import com.pixelmonmod.pixelmon.client.gui.override.ScreenModifier;
import com.pixelmonmod.pixelmon.client.gui.override.escape.cosmetic.EscapeMenuCosmeticModifier;
import com.pixelmonmod.pixelmon.client.gui.override.load.ServerConnectModifier;
import com.pixelmonmod.pixelmon.client.gui.override.load.WorldLoadModifier;
import com.pixelmonmod.pixelmon.client.gui.override.main.MainMenuModifier;
import com.pixelmonmod.pixelmon.client.gui.override.multiplayer.MultiplayerScreenModifier;
import net.shizotoaster.pixelcringe.config.PixelCringeConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MenuOverrideFactory.class)
public class MenuOverrideFactoryMixin {
    @Inject(method = "registerModifier", at = @At("HEAD"), cancellable = true, remap = false)
    private static void pixelcringe$fuckRegisterModifier(ScreenModifier modifier, CallbackInfo ci) {
        if (modifier instanceof EscapeMenuCosmeticModifier && PixelCringeConfig.ESCAPE_MENU_MODIFIER_PATCH.get()) ci.cancel();
        if (modifier instanceof WorldLoadModifier && PixelCringeConfig.WORLD_LOAD_MODIFIER_PATCH.get()) ci.cancel();
        if (modifier instanceof ServerConnectModifier && PixelCringeConfig.SERVER_CONNECT_MODIFIER_PATCH.get()) ci.cancel();
        if (modifier instanceof MainMenuModifier && PixelCringeConfig.MAIN_MENU_MODIFIER_PATCH.get()) ci.cancel();
        if (modifier instanceof MultiplayerScreenModifier && PixelCringeConfig.MULTIPLAYER_SCREEN_MODIFIER_PATCH.get()) ci.cancel();
    }
}
