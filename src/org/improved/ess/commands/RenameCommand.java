package org.improved.ess.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.improved.ess.utils.Chat;

public class RenameCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        if (sender.hasPermission("command.item.rename")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED+  "/rename <arguments>");
                return true;
            }

            Player p = (Player) sender;

            ItemStack item = p.getItemInHand();

            if (item == null) {
                sender.sendMessage(ChatColor.RED + "Failed to name that!");
                return true;
            }

            if (item.getType() == Material.AIR) {
                sender.sendMessage(ChatColor.RED + "Failed to name that!");
                return true;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i<args.length; i ++) {
                builder.append(args[i] + " ");
            }

            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(Chat.c(builder.toString()));

            item.setItemMeta(meta);

            p.updateInventory();

            p.sendMessage(Chat.c("&eThe item in your hand has been renamed to " + builder.toString()));

            return true;

        }

        return false;
    }
}
