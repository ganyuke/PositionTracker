package org.ganyuke.postrack;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.ganyuke.postrack.listeners.PlayerJoinListener;

public final class PositionTracker extends JavaPlugin implements Listener {
    static PositionTracker plugin;
    public static PositionTracker getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        this.getLogger().info("plugin hath been loaded");
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
