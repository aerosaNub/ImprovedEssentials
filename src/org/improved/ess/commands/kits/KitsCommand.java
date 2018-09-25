package org.improved.ess.commands.kits;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

import java.util.ArrayList;
import java.util.List;

public class KitsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "/" + label + " <kitname>");
            return true;
        }

        Player player = (Player) sender;

        String name = args[0].toLowerCase();

        for (String key : Essentials.getEssentials().getKitFile().getConfiguration().getConfigurationSection("ServerKits").getKeys(false)) {
            if (name.equalsIgnoreCase(key.toLowerCase())) {
                if (sender.hasPermission("kits." + name)) {
                    Essentials.getEssentials().getKitFile().loadKit(player, name.toLowerCase());
                    sender.sendMessage(Chat.c("&eYou were given the kit " + name.toUpperCase()));
                } else {
                    sender.sendMessage(ChatColor.RED + "You do not have permissions to use the " + name.toUpperCase() + " kit!");
                    return true;
                }
            }
        }
        return false;
    }
}
