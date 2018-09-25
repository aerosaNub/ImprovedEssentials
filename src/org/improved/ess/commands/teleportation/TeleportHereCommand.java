package org.improved.ess.commands.teleportation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

public class TeleportHereCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if (sender.hasPermission("command.teleporthere")) {
            if (args.length == 0) {
                sender.sendMessage(Chat.c("&c/tphere <player>"));
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(Chat.c("&cPlayer couldn't be found!"));
                return true;
            }

            Player p = (Player) sender;

            target.teleport(p.getLocation());

            p.sendMessage(Chat.c("&eYou have teleported the user &a" + target.getName() + " to your destination!"));
            target.sendMessage(Chat.c("&eTeleported to &a" + p.getName() + "&e!"));
            return true;
        }
        return false;
    }
}

