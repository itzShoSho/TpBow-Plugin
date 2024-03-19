package me.itzshosho.teleportbow.listeners;

import me.itzshosho.teleportbow.TeleportBow;
import me.itzshosho.teleportbow.utility.BowUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class TpBowListener implements Listener {

    private final HashMap<UUID, Long> cooldown;

    public TpBowListener(){
        this.cooldown = new HashMap<>();
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e){

        //check to see if it was shot by the tp bow
        if(e.getEntity().getShooter() instanceof Player p){
            if(!cooldown.containsKey(p.getUniqueId())){
                this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                ItemStack shotBow = p.getInventory().getItemInMainHand();

                if(shotBow.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', TeleportBow.getPlugin().getConfig().getString("bow-name")))){

                    Location loc = e.getEntity().getLocation();

                    p.teleport(loc);
                    e.getEntity().remove();
                    p.sendMessage(TeleportBow.getPlugin().getConfig().getString("teleported-message"));
                    p.playSound(p, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);
                }
            }else {
                long timeElapsedMs = System.currentTimeMillis() - cooldown.get(p.getUniqueId());
                long timeElapsedS = timeElapsedMs / 1000;

                if(timeElapsedS >= TeleportBow.getPlugin().getConfig().getInt("cooldown-Bow")){
                    this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                    Location loc = e.getEntity().getLocation();

                    p.teleport(loc);
                    e.getEntity().remove();
                    p.sendMessage(TeleportBow.getPlugin().getConfig().getString("teleported-message"));
                    p.playSound(p, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);
                }else {
                    p.sendMessage(ChatColor.RED + "Slow down and wait for another: " + (TeleportBow.getPlugin().getConfig().getInt("cooldown-Bow") - timeElapsedS) + " second/s");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if(TeleportBow.getPlugin().getConfig().getBoolean("give-on-join")){

            Player p = e.getPlayer();
            p.getInventory().addItem(BowUtils.createTpBow());
            p.getInventory().addItem(new ItemStack(Material.ARROW));

            p.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome, here is a tp bow to play with.");

        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        Player p = e.getPlayer();
        p.getInventory().remove(BowUtils.createTpBow());
        p.getInventory().remove(new ItemStack(Material.ARROW));
    }
}
