package me.aqua.fadebans.commands;

import me.aqua.fadebans.menus.MainMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage(color("&3(!) &b/fademute &f<player>"));
            }
            if (args.length == 1) {
                Player player = (Player) sender;
                MainMenu gui = new MainMenu(player);
                gui.open(player);
            }
        }
        return false;
    }
}
