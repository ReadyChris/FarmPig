/*
 * Copyright (c) vom Plugin TigerMC liegt bei Christopher Brehm
 * Plugin erstellt am 25.03.20, 15:22
 * Alle Rechte vorbehalten.
 */

package de.qebusted.testplugin.tigermc.listener;

import de.qebusted.testplugin.tigermc.TigerMC;
import de.qebusted.testplugin.tigermc.utils.Data;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageListener implements Listener {

    public EntityDamageListener() {
        TigerMC.getInstance().getServer().getPluginManager().registerEvents(this, TigerMC.getInstance());
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Pig) {
            if (event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                if(Data.killFarmPig.contains(player)) {
                    entity.remove();
                    Data.killFarmPig.remove(player);
                    player.sendMessage(Data.prefix + "§7Du hast das §dSchwein §centfernt");
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1,1);
                }
            }
        }
    }

}
