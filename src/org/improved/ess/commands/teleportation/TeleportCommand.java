package org.improved.ess.commands.teleportation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.utils.Chat;

public class TeleportCommand
        implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(Chat.c("&c/teleport <player> | /teleport <player> <target>"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Havent joined the server before!");
            return true;
        }

        if (!target.isOnline()) {
            sender.sendMessage(ChatColor.RED + "Player is not online!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 1) {
            player.teleport(target.getLocation());
            player.sendMessage(Chat.c("&eYou have been teleported to the user &a" + target.getName()));
            return true;
        }

        Player target2 = Bukkit.getPlayer(args[1]);

        if (target2 == null) {
            sender.sendMessage(ChatColor.RED + "Havent joined the server before!");
            return true;
        }

        if (!target2.isOnline()) {
            sender.sendMessage(ChatColor.RED + "Player is not online!");
            return true;
        }


        target.teleport(target2.getLocation());



        return true;
    }
}

