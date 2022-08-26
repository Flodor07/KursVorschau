package de.flodo07.kurs.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    private String fileName;
    private File file;
    private File dir;
    private FileConfiguration config;

    public Config(String name, Plugin plugin) {
        this.fileName = name + ".yml";

        this.dir = plugin.getDataFolder();
        this.file = new File(dir, fileName);

        try {
            setup();
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage("IO Exception happened while creating config");
        }


    }

    private void setup() throws IOException {
        if(!dir.exists()) dir.mkdirs();

        if(!file.exists()) {
            file.createNewFile();
        }

        config = YamlConfiguration.loadConfiguration(file);
        config.options().copyDefaults(true);
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage("IO Exception happened while creating config");
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }



}
