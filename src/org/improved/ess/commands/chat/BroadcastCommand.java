package org.improved.ess.commands.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.utils.Chat;

public class BroadcastCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("core.broadcast")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Specify arguments!");
                return true;
            }

            StringBuilder string = new StringBuilder();
            for (int i = 0; i < args.length; i++ ){
                string.append(args[i] + " ");
            }

            Bukkit.broadcastMessage(Chat.c(string.toString()));

            return true;
        }
        return false;
    }
}
