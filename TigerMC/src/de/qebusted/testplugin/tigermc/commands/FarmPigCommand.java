/*
 * Copyright (c) vom Plugin TigerMC liegt bei Christopher Brehm
 * Plugin erstellt am 25.03.20, 15:12
 * Alle Rechte vorbehalten.
 */

package de.qebusted.testplugin.tigermc.commands;

import de.qebusted.testplugin.tigermc.objects.FarmPig;
import de.qebusted.testplugin.tigermc.utils.Data;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FarmPigCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 1) {
                if(args[0].equalsIgnoreCase("spawn")) {
                    if (player.hasPermission("farmpig.spawn")) {
                        FarmPig farmPig = new FarmPig(player.getLocation());
                        farmPig.spawn();
                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        player.sendMessage(Data.noperms);
                    }
                } else if(args[0].equalsIgnoreCase("kill")) {
                    if(player.hasPermission("farmpig.kill")) {
                        if (!Data.killFarmPig.contains(player)) {
                            Data.killFarmPig.add(player);
                            player.sendMessage(Data.prefix + "§aKlicke §7das §dSchwein §7an, dass du §centfernen §7möchtest.");
                        } else {
                            player.sendMessage(Data.prefix + "§cDer Vorgang wurde abgebrochen");
                        }
                    } else {
                        player.sendMessage(Data.noperms);
                    }
                } else {
                    sendHelp(player);
                }
            } else {
                sendHelp(player);
            }
        }
        return false;
    }

    private void sendHelp(Player player) {
        player.sendMessage(Data.prefix + "§cFalscher Syntax. Benutze:");
        player.sendMessage(Data.prefix + "§7/spawnpig spawn");
        player.sendMessage(Data.prefix + "§7/spawnpig kill");

    }

}
