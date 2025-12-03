package org.sample.fleeonsight.AnimalStateSystem;

import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import org.sample.fleeonsight.LogicAttributes;

import static org.sample.fleeonsight.EntityUtils.getMobState;

public class AnimalGroupFleeManager {
    public static void manageSheepGroupFlee(SheepEntity sheep) {
        if (getMobState(sheep).isFleeing) {
            var world = sheep.getWorld();
            var nearbySheep = world.getEntitiesByClass(
                    SheepEntity.class,
                    sheep.getBoundingBox().expand(LogicAttributes.GROUP_FLEE_RADIUS),
                    s -> s != sheep
            );
            for (SheepEntity otherSheep : nearbySheep) {
                var otherSheepState = getMobState(otherSheep);
                if (!otherSheepState.isFleeing) {
                    otherSheepState.isFleeing = true;
                }
            }
        }
    }

    public static void manageCowGroupFlee(CowEntity cow) {
        if (getMobState(cow).isFleeing) {
            var world = cow.getWorld();
            var nearbyCow = world.getEntitiesByClass(
                    CowEntity.class,
                    cow.getBoundingBox().expand(LogicAttributes.GROUP_FLEE_RADIUS),
                    s -> s != cow
            );
            for (CowEntity otherCow : nearbyCow) {
                var otherSheepState = getMobState(otherCow);
                if (!otherSheepState.isFleeing) {
                    otherSheepState.isFleeing = true;
                }
            }
        }
    }

    public static void managePigGroupFlee(PigEntity pig) {
        if (getMobState(pig).isFleeing) {
            var world = pig.getWorld();
            var nearbyPig = world.getEntitiesByClass(
                    PigEntity.class,
                    pig.getBoundingBox().expand(LogicAttributes.GROUP_FLEE_RADIUS),
                    s -> s != pig
            );
            for (PigEntity otherPig : nearbyPig) {
                var otherSheepState = getMobState(otherPig);
                if (!otherSheepState.isFleeing) {
                    otherSheepState.isFleeing = true;
                }
            }
        }

    }


}
