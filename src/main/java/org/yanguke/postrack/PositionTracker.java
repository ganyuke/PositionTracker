package org.yanguke.postrack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PositionTracker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("plugin hath been loaded");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.getLogger().info("PLAYER JOINED: " + event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        this.getLogger().info("PLAYER LEFT: " + event.getPlayer().getName());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
