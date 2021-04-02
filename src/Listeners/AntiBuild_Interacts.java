// Copyright© by Fin

package Listeners;

import Main.Main;
import io.netty.handler.codec.haproxy.HAProxyTLV;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AntiBuild_Interacts implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals("world") || p.getWorld().getName().equals("world_nether")
                || p.getWorld().getName().equals("world_the_end")) {
            if (!Main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
                p.sendMessage(Main.pre + " §cProtected!");
                return;
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals("world") || p.getWorld().getName().equals("world_nether")
                || p.getWorld().getName().equals("world_the_end")) {
            if (!Main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
                p.sendMessage(Main.pre + " §cProtected!");
                return;
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        boolean world = e.getEntity().getWorld().getName().equals("world");
        boolean nether = e.getEntity().getWorld().getName().equals("world_nether");
        boolean end = e.getEntity().getWorld().getName().equals("world_the_end");
        if (world || nether || end) {
            if (!Main.allowedPlayer.contains(e.getEntity())) {
                e.setCancelled(true);
                e.getEntity().sendMessage("Nein");
                return;
            }
        } else {
            return;
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