package org.improved.ess.commands.teleportation;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.utils.Chat;

public class TeleportPositionCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if (sender.hasPermission("command.teleportposition")) {
            if (args.length < 2) {
                sender.sendMessage(Chat.c("&c/tppos <x> <y> <z>"));
                return true;
            }

            Integer x = Integer.parseInt(args[0]);

            if (x == null) {
                sender.sendMessage(Chat.c("&cSpecify a real number for x!"));
                return true;
            }

            Integer y = Integer.parseInt(args[1]);

            if (y == null) {
                sender.sendMessage(Chat.c("&cSpecify a real number for y!"));
                return true;
            }

            Integer z = Integer.parseInt(args[2]);

            if (z == null) {
                sender.sendMessage(Chat.c("&cSpecify a real number for z!"));
                return true;
            }

            Player p = (Player) sender;

            teleportLocation(p, x, y, z);

            p.sendMessage(Chat.c("&eYou have been teleported to the position &a" + x + " " + y + " " + z + "&e!"));

            return true;
        }
        return false;
    }

    public void teleportLocation(Player player, int x, int y, int z) {
        Location loc = new Location(player.getWorld(), x, y, z);

        player.teleport(loc);
    }
}

