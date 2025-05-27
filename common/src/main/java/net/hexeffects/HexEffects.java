package net.hexeffects;

import net.hexeffects.registry.HexEffectsIotaTypeRegistry;
import net.hexeffects.registry.HexEffectsItemRegistry;
import net.hexeffects.registry.HexEffectsPatternRegistry;
import net.hexeffects.networking.HexEffectsNetworking;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class HexEffects {
    public static final String MOD_ID = "hexeffects";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("HexEffects says hello!");

        HexEffectsAbstractions.initPlatformSpecific();
        HexEffectsItemRegistry.init();
        HexEffectsIotaTypeRegistry.init();
        HexEffectsPatternRegistry.init();
		HexEffectsNetworking.init();

        LOGGER.info(HexEffectsAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
