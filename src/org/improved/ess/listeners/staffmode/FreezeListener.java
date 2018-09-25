package org.improved.ess.listeners.staffmode;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.improved.ess.Essentials;

public class FreezeListener implements Listener {

    @EventHandler
    public void onEntityInteraction(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Entity entity = e.getRightClicked();

        if (!(entity instanceof Player)) return;

        Player clicked = (Player) entity;

        if (Essentials.getEssentials().getPlayerHandler().inStaff(p)) {
            if (Essentials.getEssentials().getPlayerHandler().getBoolean(p)) {
                // FREEZE
            }
        }
    }
}
