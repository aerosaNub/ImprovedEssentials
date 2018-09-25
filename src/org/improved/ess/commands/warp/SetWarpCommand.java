package org.improved.ess.commands.warp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.flatfiles.WarpFlatFile;
import org.improved.ess.managers.Warps;
import org.improved.ess.utils.Chat;

public class SetWarpCommand implements CommandExecutor {

    private WarpFlatFile warpFlatFile = new WarpFlatFile(Essentials.getEssentials());

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player Usage");
            return true;
        }

        if (sender.hasPermission("core.setwarp")) {
            if (args.length == 0) {
                sender.sendMessage(Chat.c("&c/setwarp <name>"));
                return true;
            }

            String name = args[0];


            Player player = (Player) sender;

            Essentials.getEssentials().getWarpFlatFile().createWarps(player, name);
            player.sendMessage(Chat.c(name + " warp has been set at your location!"));
            return true;

        }
        return false;
    }
}

