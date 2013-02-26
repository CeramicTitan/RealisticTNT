package net.obnoxint.mcdev.realistictnt;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class RealisticTNT extends JavaPlugin implements Listener {

    private RealisticTNTConfiguration configuration;

    @Override
    public void onDisable() {
        configuration.store();
        saveConfig();
    }

    @Override
    public void onEnable() {
        configuration = new RealisticTNTConfiguration(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onLoad() {
        getDataFolder().mkdirs();
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    void onEntityExplode(final EntityExplodeEvent event) {
        final World w = event.getLocation().getWorld();
        if (configuration.getEnabledWorlds().contains(event.getLocation().getWorld().getName())) {
            final List<Block> blocks = event.blockList();
            for (final Block b : blocks) {
                if (!BlockExclusion.excluded(b.getType())) {
                    final FallingBlock fb = w.spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
                    final Vector v = new Vector()
                            .add(b.getLocation().toVector())
                            .subtract(event.getEntity().getLocation().toVector())
                            .multiply(1D / b.getLocation().distance(event.getEntity().getLocation()));
                    fb.setVelocity(v);
                    fb.setDropItem(false);
                }
                if (!b.getType().equals(Material.TNT)) { // Allow chain reactions.
                    b.setType(Material.AIR);
                }
            }
        }
    }

}
