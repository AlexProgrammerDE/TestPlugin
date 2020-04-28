package me.alexprogrammerde.testplugin.listener;

import me.alexprogrammerde.testplugin.main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import me.alexprogrammerde.testplugin.main;

import static org.bukkit.Material.*;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();

        ItemStack compass = new ItemStack(COMPASS);
        ItemStack end_crystal = new ItemStack(END_CRYSTAL);
        ItemStack cake = new ItemStack(CAKE);

        ItemStack ice = new ItemStack(PACKED_ICE);
        ItemStack nether_star = new ItemStack(NETHER_STAR);
        ItemStack red_torch = new ItemStack(REDSTONE_TORCH);

        inv.clear();

        // Hotbar
        inv.setItem(1, compass);
        inv.setItem(4, end_crystal);
        inv.setItem(7, cake);

        // Inventory
        inv.setItem(19, ice);
        inv.setItem(22, nether_star);
        inv.setItem(25, red_torch);

        inv.setHeldItemSlot(4);

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§ktext §r§lYou can expand the menu with sneaking! §ktext").create());


    }
}
