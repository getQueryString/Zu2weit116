// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.projectiles.BlockProjectileSource;

public class onDeath implements Listener {

    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        if (p instanceof Player) {
            if (p.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setDeathMessage(Main.pre + " §e" + p.getName() + " §ffiel aus zu großer Höhe.");
            }
        }
        /*if (k != null) {
            if (k instanceof Player) {
                e.setDeathMessage(
                        Main.pre + " §e" + p.getName() + " §fwurde von §e" + k.getName() + " §fgetötet.");
            }
        }*/
        if (e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent lastDamageCause = (EntityDamageByEntityEvent) e.getEntity().getLastDamageCause();
            Entity killer = lastDamageCause.getDamager();
            if (killer instanceof Entity && !(killer instanceof Creeper)) {
                e.setDeathMessage(
                        Main.pre + " §e" + p.getName() + " §fwurde von §e" + killer.getName() + " §ferschlagen.");
                Arrow arrow = (Arrow) lastDamageCause.getDamager();
                if (arrow.getShooter() instanceof Entity) {
                    e.setDeathMessage(Main.pre + " §e" + p.getName() + " §fwurde von §e" + ((Entity) arrow.getShooter()).getName() + " §ferschossen.");
                    if (p == k) {
                        e.setDeathMessage(Main.pre + " §e" + p.getName() + " §fhat sich erschossen.");
                    }
                } else if (arrow.getShooter() instanceof BlockProjectileSource) {
                    e.setDeathMessage(Main.pre + " §e" + p.getName() + " §fwurde von §ePfeil §ferschossen.");
                }
            } else if (killer instanceof Creeper) {
                e.setDeathMessage(
                        Main.pre + " §e" + p.getName() + " §fwurde von §e" + killer.getName() + " §fin die Luft gesprengt.");
            } else if (lastDamageCause.getDamager() instanceof Trident) {
                Trident trident = (Trident) lastDamageCause.getDamager();
                if (trident.getShooter() instanceof Drowned) {
                    e.setDeathMessage(Main.pre + " §e" + p.getName() + " §fwurde von §eErtrunkener §fdurch einen §aDreizack §ferschossen.");
                } else if (trident.getShooter() instanceof Player) {
                    e.setDeathMessage(Main.pre + " §e" + p.getName() + " §fwurde von §e" + k.getName() + " durch einen §aDreizack §ferschossen.");
                }
            }
        }
    }
}