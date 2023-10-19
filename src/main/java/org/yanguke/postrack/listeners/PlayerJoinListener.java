package org.yanguke.postrack.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.yanguke.postrack.PositionTracker;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        PositionTracker.getPlugin().getLogger().info("PLAYER JOINED: " + event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        PositionTracker.getPlugin().getLogger().info("TRACKING PLAYER: " + event.getPlayer().getName() + ". DETECTED MOVEMENT: " + event.getTo() + " AT TIME: " + System.currentTimeMillis() / 1000L);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        PositionTracker.getPlugin().getLogger().info("PLAYER LEFT: " + event.getPlayer().getName());
    }
}
