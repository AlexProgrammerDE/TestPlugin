package me.alexprogrammerde.testplugin;

import net.md_5.bungee.api.plugin.Plugin;

public class main extends Plugin {
    @Override
    public void onEnable() {
        /*
         You should not put an enable message in your plugin.
         BungeeCord already does so
        */
        getLogger().info("Yay! It loads!");
    }
}