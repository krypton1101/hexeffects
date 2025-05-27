package net.hexeffects.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexeffects.HexEffectsClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexEffectsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HexEffectsClient.init();
    }
}
