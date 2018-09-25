package org.improved.ess.utils;

import org.bukkit.ChatColor;

public class Chat
{
    public static String c(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
