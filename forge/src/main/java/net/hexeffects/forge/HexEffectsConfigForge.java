package net.hexeffects.forge;

import at.petrak.hexcasting.api.misc.MediaConstants;
import net.hexeffects.api.config.HexEffectsConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class HexEffectsConfigForge {

    public static void init() {
        Pair<Common, ForgeConfigSpec> config = (new ForgeConfigSpec.Builder()).configure(Common::new);
        Pair<Client, ForgeConfigSpec> clientConfig = (new ForgeConfigSpec.Builder()).configure(Client::new);
        Pair<Server, ForgeConfigSpec> serverConfig = (new ForgeConfigSpec.Builder()).configure(Server::new);
        HexEffectsConfig.setCommon(config.getLeft());
        HexEffectsConfig.setClient(clientConfig.getLeft());
        HexEffectsConfig.setServer(serverConfig.getLeft());
        ModLoadingContext mlc = ModLoadingContext.get();
        mlc.registerConfig(ModConfig.Type.COMMON, config.getRight());
        mlc.registerConfig(ModConfig.Type.CLIENT, clientConfig.getRight());
        mlc.registerConfig(ModConfig.Type.SERVER, serverConfig.getRight());
    }

    public static class Common implements HexEffectsConfig.CommonConfigAccess {
        public Common(ForgeConfigSpec.Builder builder) {

        }
    }

    public static class Client implements HexEffectsConfig.ClientConfigAccess {
        public Client(ForgeConfigSpec.Builder builder) {

        }
    }

    public static class Server implements HexEffectsConfig.ServerConfigAccess {
        // costs of actions
        private static ForgeConfigSpec.DoubleValue congratsCost;
        private static ForgeConfigSpec.DoubleValue signumCost;

        public Server(ForgeConfigSpec.Builder builder) {
            builder.translation("text.autoconfig.hexeffects.option.server.costs").push("costs");

            congratsCost = builder.translation("text.autoconfig.hexeffects.option.server.costs.congratsCost").defineInRange("congratsCost", DEFAULT_CONGRATS_COST, DEF_MIN_COST, DEF_MAX_COST);
            signumCost = builder.translation("text.autoconfig.hexeffects.option.server.costs.signumCost").defineInRange("signumCost", DEFAULT_SIGNUM_COST, DEF_MIN_COST, DEF_MAX_COST);

            builder.pop();
        }

        @Override
        public int getCongratsCost() {
            return (int) (congratsCost.get() * MediaConstants.DUST_UNIT);
        }

        @Override
        public int getSignumCost() {
            return (int) (signumCost.get() * MediaConstants.DUST_UNIT);
        }
    }
}
