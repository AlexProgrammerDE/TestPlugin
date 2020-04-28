package me.alexprogrammerde.testplugin;

import me.alexprogrammerde.testplugin.listener.InventoryListener;
import me.alexprogrammerde.testplugin.listener.JoinListener;
import me.alexprogrammerde.testplugin.listener.SneakListener;
import me.alexprogrammerde.testplugin.utils.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class main extends JavaPlugin {
    private File customConfigFile;
    private FileConfiguration customConfig;
    public Server server = getServer();
    public JavaPlugin plugin = this;

    @Override
    public void onEnable() {
        server.getConsoleSender().sendMessage(ChatColor.GREEN + "[TestPlugin] Loading Config");

        SettingsManager.setup(this, "config.yml");
        SettingsManager.getConfig().addDefault("Default", "Default");
        SettingsManager.getConfig().options().copyDefaults(true);
        SettingsManager.saveConfig();

        server.getConsoleSender().sendMessage(ChatColor.GREEN + "[TestPlugin] Registering Listeners");

        getServer().getPluginManager().registerEvents(new SneakListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }

}
