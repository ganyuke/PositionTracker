package org.ganyuke.postrack;

import com.opencsv.CSVWriter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.ganyuke.postrack.database.FlatfileHandler;
import org.ganyuke.postrack.listeners.PlayerJoinListener;

import java.io.FileWriter;
import java.io.IOException;

public final class PositionTracker extends JavaPlugin implements Listener {
    static PositionTracker plugin;
    private static FlatfileHandler flatfileHandler;
    public static PositionTracker getPlugin() {
        return plugin;
    }

    public static FlatfileHandler getFlatfileHandler() {
        return flatfileHandler;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        this.getLogger().info("Plugin loaded.");

        if (!getDataFolder().exists()) {
            try {
                getDataFolder().mkdirs();
            } catch (SecurityException e) {
                e.printStackTrace();
                this.getLogger().warning("Failed to create plugin data directory!");
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }

        try {
            flatfileHandler = new FlatfileHandler(
                    PositionTracker.getPlugin()
                    .getDataFolder()
                    .getAbsolutePath() +
                    "/playerPositions.csv"
            );
        } catch (IOException e) {
            e.printStackTrace();
            PositionTracker.getPlugin().getLogger().warning("Failed to create plugin CSV file!");
            Bukkit.getPluginManager().disablePlugin(PositionTracker.getPlugin());
        }

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getLogger().info("Events registered.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
