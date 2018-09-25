package org.improved.ess.managers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerHandler {

    private ArrayList<UUID> god = new ArrayList<>();
    private HashMap<UUID, Boolean> staffmode = new HashMap<>();
    private HashMap<UUID, ItemStack[]> inventory = new HashMap<>();
    private HashMap<UUID, ItemStack[]> armor = new HashMap<>();

    public void setGod(Player p) {
        this.god.add(p.getUniqueId());
    }

    public void removeGod(Player p) {
        this.god.remove(p.getUniqueId());
    }

    public boolean isGod(Player p) {
        return this.god.contains(p.getUniqueId());
    }

    public void putInStaff(Player player) {
        this.staffmode.put(player.getUniqueId(), true);
    }

    public void removeStaff(Player player) {
        this.staffmode.put(player.getUniqueId(), false);
    }

    public boolean inStaff(Player player) {
        return this.staffmode.containsKey(player.getUniqueId());
    }

    public boolean getBoolean(Player player) {
        return this.staffmode.get(player.getUniqueId());
    }

    public void saveALLContents(Player p) {
        this.inventory.put(p.getUniqueId(), p.getInventory().getContents());
        this.armor.put(p.getUniqueId(), p.getInventory().getArmorContents());
    }

    public void loadSaveContents(Player p) {
        p.getInventory().setContents(this.inventory.get(p.getUniqueId()));
    }

    public void loadSaveAContents(Player p) {
        p.getInventory().setArmorContents(this.armor.get(p.getUniqueId()));
    }

    public boolean hasSaveContents(Player p) {
        return this.inventory.containsKey(p.getUniqueId());
    }

    public boolean hasSaveAContents(Player p) {
        return this.armor.containsKey(p.getUniqueId());
    }


}
