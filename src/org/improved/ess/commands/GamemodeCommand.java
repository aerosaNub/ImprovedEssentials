package org.improved.ess.commands;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.utils.Chat;

public class GamemodeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Chat.c("&cPlayer command only!"));
            return true;
        }

        Player player = (Player) sender;

        if (sender.hasPermission("core.gamemode")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "/gamemode <type>");
                return true;
            }

            GameMode mode = getGamemode(args[0].toLowerCase());

            if (mode == null) {
                player.sendMessage(ChatColor.YELLOW + "Avaliable GameMode Types: [Survival, Creative, Adventure]");
                return true;
            }

            player.setGameMode(mode);
            player.sendMessage(Chat.c("&9&lGamemode » &e" + WordUtils.capitalize(mode.toString())));
            return true;
        }
        return false;
    }

    private GameMode getGamemode(String str) {
        try {
            int gamemode = Integer.parseInt(str);
            return GameMode.getByValue(gamemode);
        } catch (NumberFormatException ignored) {
        }
        for (GameMode mode : GameMode.values()) {
            if (mode.toString().toLowerCase().startsWith(str) || mode.toString().equalsIgnoreCase(str)) {
                return mode;
            }
        }
        return null;
    }
}
