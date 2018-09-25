package org.improved.ess.commands.kits;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

public class CreateKitCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only retard!");
            return true;
        }

        if (sender.hasPermission("command.createkit")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "/createkit <name>");
                return true;
            }

            Player p = (Player) sender;

            Essentials.getEssentials().getKitFile().createKit(p, args[0]);

            p.sendMessage(Chat.c("&eYou have successfully created the kit &7&o" + args[0] + "&e!"));

            return true;
        }
        return false;
    }
}
