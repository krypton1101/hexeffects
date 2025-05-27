package net.hexeffects.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hexeffects.HexEffectsAbstractions;

import java.nio.file.Path;

public class HexEffectsAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexEffectsAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        HexEffectsConfigFabric.init();
    }
}
