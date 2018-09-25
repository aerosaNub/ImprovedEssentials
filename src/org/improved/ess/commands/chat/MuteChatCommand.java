package org.improved.ess.commands.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.managers.ChatHandler;
import org.improved.ess.utils.Chat;

public class MuteChatCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Players Only!");
            return true;
        }

        if (sender.hasPermission("core.chatlock")) {
            if (args.length == 0) {
                sender.sendMessage(Chat.c("&9&lChat » &c/chat mode <lock:unlock>"));
                return true;
            }

            if (args[0].equalsIgnoreCase("mode")) {
                if (args.length == 1) {
                    sender.sendMessage(Chat.c("&9&lChat » &c/chat mode <lock:unlock>"));
                    return true;
                }
                if (args[1].equalsIgnoreCase("lock")) {
                    if (!ChatHandler.get().chatIsMuted()) {
                        ChatHandler.get().setMutechat(true);
                        sender.sendMessage(Chat.c("&9&lChat » &eServer-Chat has been locked!"));
                        return true;
                    } else {
                        sender.sendMessage(Chat.c("&9&lChat » &eServer-Chat is already locked!"));
                        return true;
                    }
                }

                if (args[1].equalsIgnoreCase("unlock")) {
                    if (ChatHandler.get().chatIsMuted()) {
                        ChatHandler.get().setMutechat(false);
                        sender.sendMessage(Chat.c("&9&lChat » &eServer-Chat has been un-locked!"));
                        return true;
                    } else {
                        sender.sendMessage(Chat.c("&9&lChat » &eServer-Chat is already un-lock!"));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

