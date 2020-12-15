// Copyright© by Fin

package Listeners;

import Main.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class onBreak_onPlace implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals("world") || p.getWorld().getName().equals("world_nether")
                || p.getWorld().getName().equals("world_the_end")) {
            if (!main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
                p.sendMessage(main.pre + "  §cProtected!");
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
            if (!main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
                p.sendMessage(main.pre + "  §cProtected!");
                return;
            }
        } else {
            return;
        }
    }
}