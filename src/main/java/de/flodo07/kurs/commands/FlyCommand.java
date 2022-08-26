package de.flodo07.kurs.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Du musst für diesen Command ein Spieler sein");
            return false;
        }
        Player player = (Player) sender;

        if(!sender.hasPermission("svs.fly")) {
            sender.sendMessage(ChatColor.RED + "Du hast keine Berechtigund auf diesen Command");
            return false;
        }

        if(player.isFlying()) {
            player.setAllowFlight(false);
            player.setFlying(false);

            player.sendMessage(ChatColor.BLUE + "Du kannst nun nichtmehr fliegen");
            return true;
        }

        player.setAllowFlight(true);
        player.setFlying(true);

        player.sendMessage(ChatColor.BLUE + "Du kannst nun fliegen");
        return true;
    }
}
