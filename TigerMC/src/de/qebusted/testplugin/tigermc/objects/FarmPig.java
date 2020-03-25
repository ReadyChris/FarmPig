/*
 * Copyright (c) vom Plugin TigerMC liegt bei Christopher Brehm
 * Plugin erstellt am 25.03.20, 15:06
 * Alle Rechte vorbehalten.
 */

package de.qebusted.testplugin.tigermc.objects;


import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;


public class FarmPig {

    private Location location;
    private String customName;

    public FarmPig(Location location) {
        this.location = location;
        customName = "§8» §d§lTöte mich §8«";
    }

    public void spawn() {
        Pig pig = location.getWorld().spawn(location, Pig.class);
        pig.setCustomName(customName);
        pig.setCustomNameVisible(true);
        noAI(pig);
    }

    private void noAI(Entity entity) {
        net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) entity).getHandle();
        NBTTagCompound tag = nmsEntity.getNBTTag();
        if (tag == null) {
            tag = new NBTTagCompound();
        }
        nmsEntity.c(tag);
        tag.setInt("NoAI", 1);
        nmsEntity.f(tag);
    }

}
