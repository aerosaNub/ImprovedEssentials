package org.improved.ess.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.utils.Chat;

import java.lang.annotation.Target;

public class ClearInventoryCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Console isnt allow to use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (player.hasPermission("core.ci")) {
            if (args.length == 0) {
                player.getInventory().clear();
                player.sendMessage(Chat.c("&a&lArkHQ » &eInventory cleared!"));
                return true;
            }


            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(ChatColor.RED  + "Player specify was unknown to the system!");
                return true;
            }

            target.getInventory().clear();
            player.sendMessage(Chat.c("&a&lArkHQ » &e" + target.getName() + "'s inventory has been cleared!"));
            return true;
        }

        return false;
    }
}
