package club.bastonbolado.voidgenerator;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
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

    public class EmptyChunkGenerator extends ChunkGenerator {

        @Override
        @Nonnull
        public ChunkData generateChunkData(@Nonnull World world, @Nonnull Random random, int x, int z, @Nonnull BiomeGrid biome) {
            return createChunkData(world);
        }

        @Override
        @Nonnull
        public boolean canSpawn(@Nonnull World world, int x, int z) {
            return true;
        }

        @Override
        @Nonnull
        public Location getFixedSpawnLocation(World world, Random random) {
            return new Location(world, 0.0D, 64.0D, 0.0D);
        }


    }

}
