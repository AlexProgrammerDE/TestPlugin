package me.alexprogrammerde.testplugin;

import me.alexprogrammerde.testplugin.listener.InventoryListener;
import me.alexprogrammerde.testplugin.listener.JoinListener;
import me.alexprogrammerde.testplugin.listener.SneakListener;
import me.alexprogrammerde.testplugin.utils.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class main extends JavaPlugin {
    private File customConfigFile;
    private FileConfiguration customConfig;
    public ConsoleCommandSender logger = getServer().getConsoleSender();

    PluginManager manager = getServer().getPluginManager();
    private static main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        logger.sendMessage(ChatColor.GREEN + "[TestPlugin] Loading Config");

        SettingsManager.setup(this, "config.yml");
        SettingsManager.getConfig().addDefault("Default", "Default");
        SettingsManager.getConfig().options().copyDefaults(true);
        SettingsManager.saveConfig();

        logger.sendMessage(ChatColor.GREEN + "[TestPlugin] Registering Listeners");

        manager.registerEvents(new SneakListener(), this);
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }

    public static main getPlugin() {
        return plugin;
    }
}
