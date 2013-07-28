package com.github.rossrkk.utilities.world;

import java.util.Random;

import com.github.rossrkk.utilities.lib.IDs;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

//thanks vswe http://courses.vswe.se/?course=3&lecture=28&full=1

public class GenerationHandeler implements IWorldGenerator {
	
	//create generator instances
	public WorldGenerator turidiumGen;
	
	public GenerationHandeler() {
		GameRegistry.registerWorldGenerator(this);
		turidiumGen = new WorldGenMinable(IDs.blockOreTuridiumID, 8);
	}
	
	//thanks vswe http://courses.vswe.se/?course=3&lecture=28&full=1
	private void generateStandardOre(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int lowestY, int highestY){
		for (int i = 0; i < iterations; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = rand.nextInt(highestY - lowestY) + lowestY;
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, x, y, z);
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		generateStandardOre(random, chunkX, chunkZ, world, 10, turidiumGen, 0, 20);
	}

}
