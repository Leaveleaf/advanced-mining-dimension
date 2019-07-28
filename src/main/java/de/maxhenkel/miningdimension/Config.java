package de.maxhenkel.miningdimension;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {

    public static ForgeConfigSpec.DoubleValue CAVE_PERCENTAGE;
    public static ForgeConfigSpec.DoubleValue CANYON_PERCENTAGE;
    public static ForgeConfigSpec.BooleanValue GENERATE_LAVA_LAKES;
    public static ForgeConfigSpec.BooleanValue GENERATE_SPAWNERS;
    public static ForgeConfigSpec.BooleanValue GENERATE_STONE_VARIANTS;
    public static ForgeConfigSpec.BooleanValue GENERATE_ORES;
    public static ForgeConfigSpec.BooleanValue GENERATE_LAVA;

    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        Pair<ServerConfig, ForgeConfigSpec> specPairServer = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPEC = specPairServer.getRight();
        SERVER = specPairServer.getLeft();

        Pair<ClientConfig, ForgeConfigSpec> specPairClient = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPairClient.getRight();
        CLIENT = specPairClient.getLeft();
    }

    public static class ServerConfig {
        public ServerConfig(ForgeConfigSpec.Builder builder) {
            CAVE_PERCENTAGE = builder.defineInRange("world_generation.cave_percentage", 0.3D, 0D, 1D);
            CANYON_PERCENTAGE = builder.defineInRange("world_generation.canyon_percentage", 0.02D, 0D, 1D);
            GENERATE_LAVA_LAKES = builder.define("world_generation.lava_lakes", true);
            GENERATE_SPAWNERS = builder.define("world_generation.spawners", true);
            GENERATE_STONE_VARIANTS = builder.define("world_generation.stone_variants", true);
            GENERATE_ORES = builder.define("world_generation.ores", true);
            GENERATE_LAVA = builder.comment("If lava should be generated in caves below level 11").define("world_generation.lava", true);
        }
    }

    public static class ClientConfig {
        public ClientConfig(ForgeConfigSpec.Builder builder) {

        }
    }

}
