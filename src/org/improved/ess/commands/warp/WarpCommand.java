package org.improved.ess.commands.warp;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

import java.util.List;
import java.util.Set;

public class WarpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Set<String> list = Essentials.getEssentials().getWarpFlatFile().getConfiguration().getConfigurationSection("Warps").getKeys(false);

        if (args.length == 0) {
            sender.sendMessage(Chat.c("&9&lWarps: &e" + list));
            sender.sendMessage(Chat.c("&c/warp <name>"));
            return true;
        }

        String name = args[0];

        World world = Bukkit.getWorld(Essentials.getEssentials().getWarpFlatFile().getConfiguration().getString("Warps." + name + ".world"));
        double x = Essentials.getEssentials().getWarpFlatFile().getConfiguration().getDouble("Warps." + name + ".x");
        double y = Essentials.getEssentials().getWarpFlatFile().getConfiguration().getDouble("Warps." + name + ".y");
        double z = Essentials.getEssentials().getWarpFlatFile().getConfiguration().getDouble("Warps." + name + ".z");
        float yaw = (float)Essentials.getEssentials().getWarpFlatFile().getConfiguration().getDouble(("Warps." + name + ".yaw"));
        float pitch = (float)Essentials.getEssentials().getWarpFlatFile().getConfiguration().getDouble("Warps." + name + ".pitch");


        Player player = (Player) sender;

        Location loc = new Location(world, x, y, z, yaw, pitch);

        player.teleport(loc);

        player.sendMessage(Chat.c("&eTeleported to " + WordUtils.capitalize(name) + " warp!"));

        return true;
    }
}

