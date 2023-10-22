package org.ganyuke.postrack;

import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerTracker {
    public static void logPlayerPosition(PlayerMoveEvent event) {
        String playerState = "wa";
        if (event.getPlayer().isFlying()) {
            playerState = "fl";
        } else if (event.getPlayer().isInsideVehicle()) {
            playerState = "ri";
        } else if (event.getPlayer().isSwimming()) {
            playerState = "sw";
        } else if (event.getPlayer().isSprinting()) {
            playerState = "sp";
        }

        String[] data = new String[]{
                String.valueOf((System.currentTimeMillis() / 1000L)),
                String.valueOf(event.getPlayer().getUniqueId()),
                event.getTo().getWorld().getName(),
                playerState,
                String.valueOf(event.getTo().getBlockX()),
                String.valueOf(event.getTo().getBlockY()),
                String.valueOf(event.getTo().getBlockZ()),
                String.valueOf(event.getTo().getPitch()),
                String.valueOf(event.getTo().getYaw()),
                String.valueOf(event.getTo().getDirection())
        };

        PositionTracker.getFlatfileHandler().writeData(data);
    }
}
