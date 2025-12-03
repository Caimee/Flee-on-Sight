package org.sample.fleeonsight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.sample.fleeonsight.AnimalStateSystem.AnimalStateManager.CowStateAIManager;
import org.sample.fleeonsight.AnimalStateSystem.AnimalStateManager.PigStateAIManager;
import org.sample.fleeonsight.AnimalStateSystem.AnimalStateManager.SheepStateAIManager;
import org.sample.fleeonsight.AnimalStateSystem.Animalstate.MobState;
import org.sample.fleeonsight.PlayerSystem.PlayerState;

import java.util.WeakHashMap;

import static org.sample.fleeonsight.EntityUtils.*;
import static org.sample.fleeonsight.ProcessAnimalAI.*;

public class Fleeonsight implements ModInitializer {
    public static final String MOD_ID = "FleeOnSight";
    public static WeakHashMap<MobEntity, MobState> MobStates = new WeakHashMap<>();
    public static WeakHashMap<PlayerEntity, PlayerState> playerStates = new WeakHashMap<>();
    SheepStateAIManager SheepAI = new SheepStateAIManager();
    PigStateAIManager PigAI = new PigStateAIManager();
    CowStateAIManager CowAI = new CowStateAIManager();

    @Override
    public void onInitialize() {
        ServerTickEvents.END_WORLD_TICK.register(this::onWorldTick);
        System.out.println("FleeOnSight Mod initialized!");
    }

    private void onWorldTick(ServerWorld world) {
        var sheepGroup = getAllLoadedSheep(world);
        var pigGroup = getAllLoadedPig(world);
        var cowGroup = getAllLoadedCow(world);
        processSheepAI(world, sheepGroup);
        processCowAI(world, cowGroup);
        processPigAI(world, pigGroup);
    }


}


