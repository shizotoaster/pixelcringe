package net.shizotoaster.pixelcringe.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PixelCringeConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ESCAPE_MENU_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue WORLD_LOAD_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue SERVER_CONNECT_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue MAIN_MENU_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue MULTIPLAYER_SCREEN_MODIFIER_PATCH;

    public static final ForgeConfigSpec.BooleanValue FORCE_DISABLE_RPC;

    public static final ForgeConfigSpec.BooleanValue PIXELMON_ICON_PATCH;
    public static final ForgeConfigSpec.BooleanValue SERVER_LIST_PATCH;

    static {
        BUILDER.push("screens");

        ESCAPE_MENU_MODIFIER_PATCH = BUILDER.define("escapeMenuModifierPatch", true);
        WORLD_LOAD_MODIFIER_PATCH = BUILDER.define("worldLoadModifierPatch", true);
        SERVER_CONNECT_MODIFIER_PATCH = BUILDER.define("serverConnectModifierPatch", true);
        MAIN_MENU_MODIFIER_PATCH = BUILDER.define("mainMenuModifierPatch", true);
        MULTIPLAYER_SCREEN_MODIFIER_PATCH = BUILDER.define("multiplayerScreenModifierPatch", true);

        BUILDER.pop();

        BUILDER.push("discord");

        FORCE_DISABLE_RPC = BUILDER.define("forceDisableDiscordRpc", true);

        BUILDER.pop();

        BUILDER.push("misc");

        PIXELMON_ICON_PATCH = BUILDER.define("pixelmonIconPatch", true);
        SERVER_LIST_PATCH = BUILDER.define("serverListPatch", true);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
