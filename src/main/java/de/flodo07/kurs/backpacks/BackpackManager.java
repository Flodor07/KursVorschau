package de.flodo07.kurs.backpacks;

import de.flodo07.kurs.Main;
import de.flodo07.kurs.config.Config;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BackpackManager {
    private Map<UUID, Backpack> currentBackpacks = new HashMap();
    private Main main;

    public BackpackManager(Main main) {
        this.main = main;
    }

    public Backpack loadBackpackFromConfig(ConfigurationSection section, UUID uuid) {
        Backpack backpack = new Backpack(uuid);
        if (section == null) {
            currentBackpacks.put(uuid, backpack);
            return backpack;
        }

        for (Object item : section.getList(uuid.toString())) {
            if(item != null) {
                backpack.getInventory().addItem((ItemStack) item);
            }
        }

        if (currentBackpacks.containsKey(backpack)) return backpack;

        currentBackpacks.put(uuid, backpack);
        return backpack;
    }

    public void saveBackpack(Config config, Backpack backpack) {
        config.getConfig().set("backpacks." + backpack.getUuidString(), backpack.getInventory().getContents());
        config.saveConfig();
    }

    public Map<UUID, Backpack> getCurrentBackpacks() {
        return currentBackpacks;
    }

    public Backpack getBackpack(UUID uuid) {
        if(currentBackpacks.containsKey(uuid)) {
            return currentBackpacks.get(uuid);
        }

        return loadBackpackFromConfig(main.getConfiguration().getConfig().getConfigurationSection("backpacks"), uuid);
    }
}
