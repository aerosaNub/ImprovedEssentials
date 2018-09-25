package org.improved.ess.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

public class ServerListener implements Listener {


    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        Entity entity = e.getEntity();

        if (!(entity instanceof Player)) return;

        Player p = (Player) entity;

        if (Essentials.getEssentials().getPlayerHandler().isGod(p)) {
            e.setCancelled(true);
            p.sendMessage(Chat.c("&c&oThat person is currently in godmode!"));
        }

    }

}
