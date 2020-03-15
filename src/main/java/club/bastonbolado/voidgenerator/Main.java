package club.bastonbolado.voidgenerator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "github.com/BastonBolado/void-generator");
    }

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new EmptyChunkGenerator();
    }

    private static class EmptyChunkGenerator extends ChunkGenerator {

        @Override
        public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
            return createChunkData(world);
        }

        @Override
        public boolean canSpawn(World world, int x, int z) {
            return true;
        }

        @Override
        public Location getFixedSpawnLocation(World world, Random random) {
            final Location spawnLocation = new Location(world, 0.0D, 64.0D, 0.0D);
            final Location blockLocation = spawnLocation.clone().subtract(0D, 1D, 0D);
            blockLocation.getBlock().setType(Material.BEDROCK);
            return spawnLocation;
        }
    }
}
