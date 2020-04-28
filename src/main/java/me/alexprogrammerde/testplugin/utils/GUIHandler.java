package me.alexprogrammerde.testplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;

public class GUIHandler {

    public static void invIce(HumanEntity human) {
        Inventory inv = Bukkit.createInventory(human, 27, "Ice");

        human.openInventory(inv);
    }

    public static void invCompass(HumanEntity human) {
        Inventory inv = Bukkit.createInventory(human, 27, "Compass");

        human.openInventory(inv);
    }

    public static void invCrystal(HumanEntity human) {
        Inventory inv = Bukkit.createInventory(human, 27, "Crystal");

        human.openInventory(inv);
    }

    public static void invCake(HumanEntity human) {
        Inventory inv = Bukkit.createInventory(human, 27, "Cake");

        human.openInventory(inv);
    }

    public static void invTorch(HumanEntity human) {
        Inventory inv = Bukkit.createInventory(human, 27, "Torch");

        human.openInventory(inv);
    }

    public static void invStar(HumanEntity human) {
        Inventory inv = Bukkit.createInventory(human, 27, "Star");

        human.openInventory(inv);
    }
}
