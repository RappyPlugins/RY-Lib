package com.rappytv.rylib.util;

import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static final Pattern hex = Pattern.compile("#[a-fA-F0-9]{6}");
    private static final Pattern color = Pattern.compile("(?i)&([0-9A-FR])");
    private static final Pattern magic = Pattern.compile("(?i)&([K])");
    private static final Pattern bold = Pattern.compile("(?i)&([L])");
    private static final Pattern strikethrough = Pattern.compile("(?i)&([M])");
    private static final Pattern underline = Pattern.compile("(?i)&([N])");
    private static final Pattern italic = Pattern.compile("(?i)&([O])");

    public static String translateColorCodes(Player player, String message, String basePermission) {
        if(player.hasPermission(basePermission + ".hex")) {
            Matcher match = hex.matcher(message);
            while(match.find()) {
                String color = message.substring(match.start(), match.end());
                message = message.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
                match = hex.matcher(message);
            }
        }
        if(player.hasPermission(basePermission + ".colors")) {
            message = color.matcher(message).replaceAll("§$1");
        }
        if(player.hasPermission(basePermission + ".bold")) {
            message = bold.matcher(message).replaceAll("§$1");
        }
        if(player.hasPermission(basePermission + ".italic")) {
            message = italic.matcher(message).replaceAll("§$1");
        }
        if(player.hasPermission(basePermission + ".underline")) {
            message = underline.matcher(message).replaceAll("§$1");
        }
        if(player.hasPermission(basePermission + ".strikethrough")) {
            message = strikethrough.matcher(message).replaceAll("§$1");
        }
        if(player.hasPermission(basePermission + ".magic")) {
            message = magic.matcher(message).replaceAll("§$1");
        }
        return message;
    }
}
