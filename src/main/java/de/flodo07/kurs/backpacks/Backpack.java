package de.flodo07.kurs.backpacks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class Backpack {

    private final UUID uuid;
    private final Inventory inventory;

    public Backpack(UUID uuid) {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 18, ChatColor.GOLD + "Backpack");
    }

    public String getUuidString() {
        return uuid.toString();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
