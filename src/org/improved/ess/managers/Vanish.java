package org.improved.ess.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Vanish {

    private ArrayList<UUID> vanish;

    public Vanish() {
        this.vanish = new ArrayList<>();
    }

    public void addVanish(Player player) {
         this.vanish.add(player.getUniqueId());
    }

    public void removeVanish(Player player) {
        this.vanish.remove(player.getUniqueId());
    }

    public boolean vanishContains(Player player) {
        return this.vanish.contains(player.getUniqueId());
    }

    public void hideUser(Player player) {
        for (Player users : Bukkit.getServer().getOnlinePlayers()) {
            if (!users.hasPermission("core.vanish.see")) {
                users.hidePlayer(player);
                addVanish(player);
            }
        }
    }

    public void showUser(Player player) {
        for (Player users : Bukkit.getServer().getOnlinePlayers()) {
            users.showPlayer(player);
            removeVanish(player);
        }
    }
}
