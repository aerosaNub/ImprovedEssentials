package org.improved.ess.commands.teleportation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAllCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "&c/teleportall <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Havent joined the server before!");
            return true;
        }

        if (target.isOnline()) {
            sender.sendMessage(ChatColor.RED + "Player is not online!");
            return true;
        }

        for (Player players : Bukkit.getServer().getOnlinePlayers()) {
            players.teleport(target.getLocation());
        }

        Bukkit.broadcastMessage(ChatColor.YELLOW + "Everyone has been teleported to " + ChatColor.GREEN + target.getName());

        return true;
    }
}

