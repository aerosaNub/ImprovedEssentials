package org.improved.ess.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.improved.ess.utils.Chat;

public class FlightCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player can only use this!");
            return true;
        }

        Player p = (Player) sender;

        if (sender.hasPermission("core.flight")) {
            if (args.length == 0) {
                setFlight(p);
                sender.sendMessage(Chat.c("&a&lArkHQ » &bYou can set other people's fly status by using /fly <player>!"));
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                p.sendMessage(Chat.c("&cThat user wasn't found!"));
                return true;
            }

            setFlight(target);
            p.sendMessage(Chat.c("&a&lArkHQ » &aFlight has been set to true! &7&o(User: " + target.getName() + ")"));
            return true;
        }
        return false;
    }


    public void setFlight(Player user) {
        if (user.getAllowFlight()) {
            user.setAllowFlight(false);
            user.sendMessage(Chat.c("&a&lArkHQ » &cFlight has been set to false!"));
            return;
        } else {
            user.setAllowFlight(true);
            user.sendMessage(Chat.c("&a&lArkHQ » &aFlight has been set to true!"));
            return;
        }
    }
}
