package org.improved.ess.commands.staffmode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

public class StaffModeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if (sender.hasPermission("essentials.staffmode")) {
            if (Essentials.getEssentials().getPlayerHandler().inStaff(p)) {
                if (Essentials.getEssentials().getPlayerHandler().getBoolean(p)) {
                    Essentials.getEssentials().getPlayerHandler().removeStaff(p);
                    p.getInventory().setContents(null);
                    p.getInventory().setArmorContents(null);
                    p.setGameMode(GameMode.SURVIVAL);
                    if (Essentials.getEssentials().getPlayerHandler().hasSaveContents(p)) {
                        Essentials.getEssentials().getPlayerHandler().loadSaveContents(p);
                        return true;
                    }

                    if (Essentials.getEssentials().getPlayerHandler().hasSaveAContents(p)) {
                        Essentials.getEssentials().getPlayerHandler().loadSaveAContents(p);
                        return true;
                    }
                    p.updateInventory();
                    p.sendMessage(Chat.c("&eYou have been removed from &7&oStaffMode&e!"));
                    return true;
                } else if (!(Essentials.getEssentials().getPlayerHandler().getBoolean(p))) {
                    Essentials.getEssentials().getPlayerHandler().putInStaff(p);
                    Essentials.getEssentials().getPlayerHandler().saveALLContents(p);
                    p.getInventory().setContents(null);
                    p.getInventory().setArmorContents(null);
                    p.setGameMode(GameMode.CREATIVE);
                    items(p);
                    p.sendMessage(Chat.c("&eYou have been added to &7&oStaffMode&e!"));
                    return true;
                }
            }
        } else {
            sender.sendMessage(Chat.c("&cYou have no permissions to use this awesome command!"));
            return true;
        }
        return false;
    }

    private void items(Player p) {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemStack item2 = new ItemStack(Material.COMPASS);
        ItemStack item3 = new ItemStack(Material.IRON_BARDING);
        ItemStack item4 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        ItemStack vanishoff = new ItemStack(Material.SNOW_BALL);
        ItemStack vanishon = new ItemStack(Material.SLIME_BALL);

        ItemMeta meta =  item.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();
        ItemMeta meta3 = item3.getItemMeta();
        ItemMeta meta4 = item4.getItemMeta();
        ItemMeta voff = vanishoff.getItemMeta();
        ItemMeta von = vanishon.getItemMeta();

        meta.setDisplayName(Chat.c("&e&lInventory Checker"));
        meta2.setDisplayName(Chat.c("&e&lPass Through"));
        meta3.setDisplayName(Chat.c("&e&lFreeze"));
        meta4.setDisplayName(Chat.c("&e&lStaff(s) in StaffMode"));
        voff.setDisplayName(Chat.c("&e&lVanish &7(&c&oOff&7)"));
        von.setDisplayName(Chat.c("&e&lVanish &7(&a&oOn&7)"));

        item.setItemMeta(meta);
        item2.setItemMeta(meta2);
        item3.setItemMeta(meta3);
        item4.setItemMeta(meta4);
        vanishoff.setItemMeta(voff);
        vanishon.setItemMeta(von);

        p.getInventory().setItem(0, item2);
        p.getInventory().setItem(1, item);
        p.getInventory().setItem(4, item3);
        p.getInventory().setItem(7, item4);

        if (Essentials.getEssentials().getVanish().vanishContains(p)) {
            p.getInventory().setItem(8, vanishon);
        } else {
            p.getInventory().setItem(8, vanishoff);
        }

        p.updateInventory();

    }
}
