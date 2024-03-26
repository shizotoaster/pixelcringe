package net.shizotoaster.pixelcringe.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.config.ConfigFileTypeHandler;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.shizotoaster.pixelcringe.PixelCringe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PixelCringeConfig {
    private static ConfigFileTypeHandler UnsafeTOML;

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ESCAPE_MENU_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue WORLD_LOAD_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue SERVER_CONNECT_MODIFIER_PATCH;
    public static final ForgeConfigSpec.BooleanValue MAIN_MENU_MODIFIER_PATCH;

    public static final ForgeConfigSpec.BooleanValue FORCE_DISABLE_RPC;

    public static final ForgeConfigSpec.BooleanValue PIXELMON_ICON_PATCH;
    public static final ForgeConfigSpec.BooleanValue SERVER_LIST_PATCH;

    static {
        ModContainer container = ModList.get().getModContainerById(PixelCringe.MOD_ID).orElseThrow();

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

        PIXELMON_ICON_PATCH = BUILDER.define("pixelmonIconPatch", true);
        SERVER_LIST_PATCH = BUILDER.define("serverListPatch", true);

        BUILDER.pop();

        SPEC = BUILDER.build();

        ModConfig cfg = new ModConfig(ModConfig.Type.CLIENT, SPEC, container);

        for (Field f : ConfigFileTypeHandler.class.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers()) && f.getType() == ConfigFileTypeHandler.class) {
                try {
                    f.setAccessible(true);
                    if ((UnsafeTOML = (ConfigFileTypeHandler) f.get(null)) != null)
                        break;
                } catch (Throwable ignored) {}
            }
        }
        if (UnsafeTOML == null) {
            try {
                UnsafeTOML = ConfigFileTypeHandler.class.newInstance();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

        if (!SPEC.isLoaded()) {
            SPEC.acceptConfig(UnsafeTOML.reader(FMLPaths.CONFIGDIR.get()).apply(cfg));
        }

        container.addConfig(cfg);
    }
}
