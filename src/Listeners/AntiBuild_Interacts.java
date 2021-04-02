// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class AntiBuild_Interacts implements Listener {

    // Break
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(Main.pre + " §cProtected!");
        }
    }

    // Place
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(Main.pre + " §cProtected!");
        }
    }

    // EntityDamageByEntity
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            if (!Main.allowedPlayer.contains(e.getEntity())) {
                e.setCancelled(true);
                Bukkit.broadcastMessage("§cENTITY-HIT BLOCKIERT");
            }
        } else if (e.getDamager() instanceof Player) {
            if (!Main.allowedPlayer.contains(e.getDamager())) {
                e.setCancelled(true);
                Bukkit.broadcastMessage("§cSPIELER-HIT BLOCKIERT");
            }
        }
        if (e.getDamager() instanceof Projectile) {
            if (e.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) e.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    if (!Main.allowedPlayer.contains(arrow.getShooter())) {
                        e.setCancelled(true);
                        Bukkit.broadcastMessage("§cENTITY-SHOOT-BLOCKIERT");
                    }
                }
            }
        }
    }

    // PlayerInteractEntity
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType().equals(EntityType.ITEM_FRAME)) {
            if (!Main.allowedPlayer.contains(e.getPlayer())) {
                e.setCancelled(true);
                Bukkit.broadcastMessage("§cENTITIY-INTERACT-BLOCKIERT");
            }
        }
    }

    // HangingBreakByEntity
    @EventHandler
    public void onItemFrameBreak(HangingBreakByEntityEvent e) {
        if (e.getRemover() instanceof Player) {
            if (!Main.allowedPlayer.contains(e.getRemover())) {
                e.setCancelled(true);
                Bukkit.broadcastMessage("§cITEM-FRAME-BREAK-BLOCKIERT");
            }
        }
        if (e.getRemover() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getRemover();
            if (arrow.getShooter() instanceof Player) {
                if (!Main.allowedPlayer.contains(arrow.getShooter())) {
                    e.setCancelled(true);
                    Bukkit.broadcastMessage("§cITEM-FRAME-BREAK-SHOOT-BLOCKIERT");
                }
            }
        }
    }

    // HangingPlace
    @EventHandler
    public void onItemFramePlace(HangingPlaceEvent e) {
        if (e.getEntity() instanceof ItemFrame) {
            if (!Main.allowedPlayer.contains(e.getPlayer())) {
                e.setCancelled(true);
                Bukkit.broadcastMessage("§cITEM-FRAME-PLACE-BLOCKIERT");
            }
        }
    }

    // EntitySpawn
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        Entity p = e.getEntity();
        if (p instanceof Player) {

            e.setCancelled(true);
            Bukkit.broadcastMessage("KANN NICHT GESPAWNT WERDEN");

        }
    }
    /*@EventHandler
    public void onSpawnEntity(SpawnEntityEvent e) {

    }

    @EventHandler
    public void onDestroyEntity(DestroyEntityEvent e) {
    }

    @EventHandler
    public void onUseEntity(UseEntityEvent e) {

    }

    @EventHandler
    public void onDamageEvent(DamageEntityEvent e) {

    }

    @EventHandler
    public void onUseItem(UseItemEvent e) {
    }*/
}