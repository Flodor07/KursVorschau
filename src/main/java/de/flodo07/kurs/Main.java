package de.flodo07.kurs;

import de.flodo07.kurs.backpacks.BackpackManager;
import de.flodo07.kurs.commands.BackpackCommand;
import de.flodo07.kurs.commands.FlyCommand;
import de.flodo07.kurs.config.Config;
import de.flodo07.kurs.listeners.OnQuitJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class Main extends JavaPlugin {
    private Config configuration;
    private BackpackManager backpackManager;

    @Override
    public void onEnable() {
        this.configuration = new Config("config", this);
        this.backpackManager = new BackpackManager(this);

        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("backpack").setExecutor(new BackpackCommand(this));

        Bukkit.getPluginManager().registerEvents(new OnQuitJoin(), this);
    }

    @Override
    public void onDisable() {

        for(UUID key : backpackManager.getCurrentBackpacks().keySet()) {
            backpackManager.saveBackpack(configuration, backpackManager.getCurrentBackpacks().get(key));
        }

    }

    public Config getConfiguration() {
        return configuration;
    }

    public Plugin getPlugin() {
        return this;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }
}

