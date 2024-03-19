package me.itzshosho.teleportbow;

import me.itzshosho.teleportbow.commands.GiveCommand;
import me.itzshosho.teleportbow.listeners.TpBowListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    private static TeleportBow plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new TpBowListener(), this);

        getCommand("tpbow").setExecutor(new GiveCommand());


        getConfig().options().copyDefaults();
        saveDefaultConfig();

        plugin = this;
    }

    public static TeleportBow getPlugin() {
        return plugin;
    }
}
