package me.aqua.fadebans;

import me.aqua.fadebans.commands.MuteCommand;
import me.aqua.fadebans.listeners.MenuListeners;
import me.aqua.fadebans.menus.MainMenu;
import org.bukkit.plugin.java.JavaPlugin;

public final class FadeBans extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands() {
        getCommand("fademute").setExecutor(new MuteCommand());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new MenuListeners(), this);
    }
}
