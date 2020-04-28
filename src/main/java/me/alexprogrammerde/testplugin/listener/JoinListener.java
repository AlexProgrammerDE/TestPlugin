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

import java.util.ArrayList;

import static org.bukkit.Material.*;

public class JoinListener implements Listener {

    ArrayList playerList = new ArrayList<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if(!playerList.contains(player.getUniqueId())) {
            playerList.add(player.getUniqueId());
        }

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
        int TaskID;
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(), new Runnable() {
            int Message = 1;

            @Override
            public void run() {
                switch(Message){
                    case 1:
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§ktext §r§lYou can expand the menu with sneaking! §ktext").create());
                        Message++;
                        break;
                    case 2:
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§ktext §r§lYou can expand the menu with sneaking! §ktext").create());
                        Message++;
                    case 3:
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§ktext §r§lWelcome! §ktext").create());
                        Message++;
                        break;
                    case 4:
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("§ktext §r§lWelcome! §ktext").create());
                        Message = 1;
                        break;

                }

            }

            }, 0, 60 );
    }
}
