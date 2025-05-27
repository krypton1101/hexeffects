package net.hexeffects.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexeffects.HexEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(HexEffects.MOD_ID)
public class HexEffectsForge {
    public HexEffectsForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(HexEffects.MOD_ID, bus);
        bus.addListener(HexEffectsClientForge::init);
        HexEffects.init();
    }
}
