package de.flodo07.kurs.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class OnQuitJoin implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.joinMessage(Component.text(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "]" + event.getPlayer().getName()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.quitMessage(Component.text(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "]" + event.getPlayer().getName()));
    }
}
