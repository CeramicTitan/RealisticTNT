package net.obnoxint.mcdev.realistictnt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public final class RealisticTNTConfiguration {

    private static final String CONFIG_KEY_ENABLEDWORLDS = "enabledWorlds";

    private final FileConfiguration config;

    private List<String> enabledWorlds = null;

    RealisticTNTConfiguration(final RealisticTNT plugin) {
        plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
    }

    @SuppressWarnings("unchecked")
    public List<String> getEnabledWorlds() {
        if (enabledWorlds == null) {
            enabledWorlds = new ArrayList<String>();
            enabledWorlds.addAll((Collection<? extends String>) config.getList(CONFIG_KEY_ENABLEDWORLDS));
        }
        return new ArrayList<String>(enabledWorlds);
    }

    public void setWorldEnabled(final World world, final boolean enable) {
        final String n = world.getName();
        if (enable && !enabledWorlds.contains(n)) {
            enabledWorlds.add(n);
        } else if (!enable && enabledWorlds.contains(n)) {
            enabledWorlds.remove(n);
        }
    }

    void store() {
        config.set(CONFIG_KEY_ENABLEDWORLDS, enabledWorlds);
    }

}
