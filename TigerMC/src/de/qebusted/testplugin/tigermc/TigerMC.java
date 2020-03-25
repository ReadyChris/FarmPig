/*
 * Copyright (c) vom Plugin TigerMC liegt bei Christopher Brehm
 * Plugin erstellt am 25.03.20, 15:01
 * Alle Rechte vorbehalten.
 */

package de.qebusted.testplugin.tigermc;

import de.qebusted.testplugin.tigermc.commands.FarmPigCommand;
import de.qebusted.testplugin.tigermc.listener.EntityDamageListener;
import de.qebusted.testplugin.tigermc.listener.EntityDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public class TigerMC extends JavaPlugin {

    private static TigerMC instance;

    @Override
    public void onEnable() {
        instance = this;
        registerListener();
        registerCommands();
        getLogger().info("FarmPig Plugin aktiviert");
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("FarmPig Plugin deaktiviert");
    }

    private void registerListener() {
        new EntityDeathListener();
        new EntityDamageListener();
    }

    private void registerCommands() {
        getCommand("farmpig").setExecutor(new FarmPigCommand());
    }

    public static TigerMC getInstance() {
        return instance;
    }
}
