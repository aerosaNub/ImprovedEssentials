package org.improved.ess.commands.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.improved.ess.managers.ChatHandler;

public class ClearChatCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("core.clearchat")) {
            ChatHandler.get().clearChat();
            return true;
        }
        return false;
    }
}
