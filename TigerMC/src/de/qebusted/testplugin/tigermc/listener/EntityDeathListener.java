/*
 * Copyright (c) vom Plugin TigerMC liegt bei Christopher Brehm
 * Plugin erstellt am 25.03.20, 15:04
 * Alle Rechte vorbehalten.
 */

package de.qebusted.testplugin.tigermc.listener;

import de.qebusted.testplugin.tigermc.TigerMC;
import de.qebusted.testplugin.tigermc.objects.FarmPig;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathListener implements Listener {

    public EntityDeathListener() {
        TigerMC.getInstance().getServer().getPluginManager().registerEvents(this, TigerMC.getInstance());
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof Pig) {
            if(entity.getCustomName().equalsIgnoreCase("§8» §d§lTöte mich §8«")) {
                event.setDroppedExp(0);
                FarmPig pig = new FarmPig(entity.getLocation());
                pig.spawn();
            }
        }
    }

}
