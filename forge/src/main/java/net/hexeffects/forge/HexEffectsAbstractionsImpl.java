package net.hexeffects.forge;

import net.hexeffects.HexEffectsAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class HexEffectsAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexEffectsAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        HexEffectsConfigForge.init();
    }
}
