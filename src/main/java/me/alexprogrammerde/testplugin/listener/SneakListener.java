package me.alexprogrammerde.testplugin.listener;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static org.bukkit.ChatColor.*;
import static org.bukkit.Material.*;

public class SneakListener implements Listener {

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();

        ItemStack compass = new ItemStack(COMPASS);
        ItemStack end_crystal = new ItemStack(END_CRYSTAL);
        ItemStack cake = new ItemStack(CAKE);

        ItemStack ice = new ItemStack(PACKED_ICE);
        ItemStack nether_star = new ItemStack(NETHER_STAR);
        ItemStack red_torch = new ItemStack(REDSTONE_TORCH);

        inv.setHeldItemSlot(4);

        if(event.isSneaking()) {
            Bukkit.getLogger().info(GREEN + player.getDisplayName() + " is sneaking now.");

            inv.setItem(1, ice);
            inv.setItem(4, nether_star);
            inv.setItem(7, red_torch);

            inv.setItem(19, compass);
            inv.setItem(22, end_crystal);
            inv.setItem(25, cake);
        }

        if(! event.isSneaking()) {
            Bukkit.getLogger().info(RED + player.getDisplayName() + " is no longer sneaking.");

            inv.setItem(1, compass);
            inv.setItem(4, end_crystal);
            inv.setItem(7, cake);

            inv.setItem(19, ice);
            inv.setItem(22, nether_star);
            inv.setItem(25, red_torch);
        }
    }
}
