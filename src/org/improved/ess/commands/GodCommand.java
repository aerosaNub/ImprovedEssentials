package org.improved.ess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

public class GodCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

         if (!(sender instanceof Player)) {
             return true;
         }

         Player p = (Player) sender;

         if (sender.hasPermission("command.godmode")) {
             if (Essentials.getEssentials().getPlayerHandler().isGod(p)) {
                 Essentials.getEssentials().getPlayerHandler().removeGod(p);
                 p.sendMessage(Chat.c("&eGodMode has been &cdisabled &efor you!"));
                 return true;
             } else {
                 Essentials.getEssentials().getPlayerHandler().setGod(p);
                 p.sendMessage(Chat.c("&eGodMode has been &aenabled &efor you!"));
                 return true;
             }
         }
        return false;
    }
}

