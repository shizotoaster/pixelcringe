package net.shizotoaster.pixelcringe.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class PixelCringeConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ESCAPE_MENU_MODIFIER_PATCH;
    public static final ModConfigSpec.BooleanValue WORLD_LOAD_MODIFIER_PATCH;
    public static final ModConfigSpec.BooleanValue SERVER_CONNECT_MODIFIER_PATCH;
    public static final ModConfigSpec.BooleanValue MAIN_MENU_MODIFIER_PATCH;

    public static final ModConfigSpec.BooleanValue FORCE_DISABLE_RPC;

    public static final ModConfigSpec.BooleanValue SERVER_LIST_PATCH;

    static {
        BUILDER.push("screens");

        ESCAPE_MENU_MODIFIER_PATCH = BUILDER.define("escapeMenuModifierPatch", true);
        WORLD_LOAD_MODIFIER_PATCH = BUILDER.define("worldLoadModifierPatch", true);
        SERVER_CONNECT_MODIFIER_PATCH = BUILDER.define("serverConnectModifierPatch", true);
        MAIN_MENU_MODIFIER_PATCH = BUILDER.define("mainMenuModifierPatch", true);

        BUILDER.pop();

        BUILDER.push("discord");

        FORCE_DISABLE_RPC = BUILDER.define("forceDisableDiscordRpc", true);

        BUILDER.pop();

        BUILDER.push("misc");

        SERVER_LIST_PATCH = BUILDER.define("serverListPatch", true);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
