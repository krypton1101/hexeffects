package net.hexeffects.forge;

import net.hexeffects.HexEffectsClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class HexEffectsClientForge {
    public static void init(FMLClientSetupEvent event) {
        HexEffectsClient.init();
    }
}
