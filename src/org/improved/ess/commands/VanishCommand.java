package org.improved.ess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.utils.Chat;

import java.util.ArrayList;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (sender.hasPermission("core.vanish")) {
            if (Essentials.getEssentials().getVanish().vanishContains(player)) {
                Essentials.getEssentials().getVanish().showUser(player);
                player.sendMessage(Chat.c(
                        "&9&lVanish » &eMode has been set to &aInvisible."
                ));
                return true;
            } else {
                Essentials.getEssentials().getVanish().hideUser(player);
                player.sendMessage(Chat.c(
                        "&9&lVanish » &eMode has been set to &cVisable."
                ));
                return true;
            }
        }
        return false;
    }
}

