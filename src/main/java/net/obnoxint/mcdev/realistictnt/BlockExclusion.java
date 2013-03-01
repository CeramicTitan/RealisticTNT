package net.obnoxint.mcdev.realistictnt;

import static org.bukkit.Material.AIR;
import static org.bukkit.Material.BROWN_MUSHROOM;
import static org.bukkit.Material.CHEST;
import static org.bukkit.Material.FENCE;
import static org.bukkit.Material.FENCE_GATE;
import static org.bukkit.Material.FIRE;
import static org.bukkit.Material.GLASS;
import static org.bukkit.Material.ICE;
import static org.bukkit.Material.IRON_DOOR;
import static org.bukkit.Material.IRON_FENCE;
import static org.bukkit.Material.LAVA;
import static org.bukkit.Material.LEAVES;
import static org.bukkit.Material.LONG_GRASS;
import static org.bukkit.Material.MOB_SPAWNER;
import static org.bukkit.Material.MONSTER_EGGS;
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.PISTON_EXTENSION;
import static org.bukkit.Material.PISTON_MOVING_PIECE;
import static org.bukkit.Material.PISTON_STICKY_BASE;
import static org.bukkit.Material.REDSTONE_TORCH_OFF;
import static org.bukkit.Material.REDSTONE_TORCH_ON;
import static org.bukkit.Material.REDSTONE_WIRE;
import static org.bukkit.Material.RED_MUSHROOM;
import static org.bukkit.Material.RED_ROSE;
import static org.bukkit.Material.SIGN_POST;
import static org.bukkit.Material.SNOW;
import static org.bukkit.Material.STATIONARY_LAVA;
import static org.bukkit.Material.STATIONARY_WATER;
import static org.bukkit.Material.STONE_PLATE;
import static org.bukkit.Material.TNT;
import static org.bukkit.Material.TORCH;
import static org.bukkit.Material.TRAP_DOOR;
import static org.bukkit.Material.WALL_SIGN;
import static org.bukkit.Material.WATER;
import static org.bukkit.Material.WATER_LILY;
import static org.bukkit.Material.WOOD_PLATE;
import static org.bukkit.Material.WOODEN_DOOR;
import static org.bukkit.Material.YELLOW_FLOWER;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;

final class BlockExclusion {

    private static final Material[] m = {
            AIR,
            BROWN_MUSHROOM,
            CHEST,
            FENCE,
            FENCE_GATE,
            FIRE,
            GLASS,
            ICE,
            IRON_DOOR,
            IRON_FENCE,
            LAVA,
            LEAVES,
            LONG_GRASS,
            MOB_SPAWNER,
            MONSTER_EGGS,
            PISTON_BASE,
            PISTON_EXTENSION,
            PISTON_MOVING_PIECE,
            PISTON_STICKY_BASE,
            REDSTONE_TORCH_OFF,
            REDSTONE_TORCH_ON,
            REDSTONE_WIRE,
            RED_MUSHROOM,
            RED_ROSE,
            SIGN_POST,
            SNOW,
            STATIONARY_LAVA,
            STATIONARY_WATER,
            STONE_PLATE,
            TNT,
            TORCH,
            TRAP_DOOR,
            WALL_SIGN,
            WATER,
            WATER_LILY,
            WOOD_PLATE,
            WOODEN_DOOR,
            YELLOW_FLOWER
    };

    private static final Set<Material> materials = new HashSet<Material>();

    static {
        for (int i = 0; i < m.length; i++) {
            materials.add(m[i]);

        }
    }

    static boolean excluded(final Material material) {
        return materials.contains(material);
    }
}
