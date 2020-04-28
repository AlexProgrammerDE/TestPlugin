package me.alexprogrammerde.testplugin.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import me.alexprogrammerde.testplugin.utils.GUIHandler;

public class InventoryListener implements Listener {

    int compass = 1;
    int end_crystal = 4;
    int cake = 7;

    int ice = 19;
    int nether_star = 22;
    int red_torch = 25;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // High priority
        HumanEntity human = event.getWhoClicked();
        if(human.getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(true);

        // Low priority
        int slot = event.getSlot();

        if(slot == compass) {
            GUIHandler.invCompass(human);
        }

        if(slot == cake) {
            GUIHandler.invCake(human);
        }

        if(slot == red_torch) {
            GUIHandler.invTorch(human);
        }

        if(slot == nether_star) {
            GUIHandler.invStar(human);
        }

        if(slot == end_crystal) {
            GUIHandler.invCrystal(human);
        }

        if(slot == ice) {
            GUIHandler.invIce(human);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        // High priority
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // High priority
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(true);

        // Low priority
        ItemStack currentItem = event.getItem();
        HumanEntity human = player.getPlayer();
        PlayerInventory inv = human.getInventory();
        int slot = inv.getHeldItemSlot();

    }
}
