// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onDrop_EVENT implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if ((p.getWorld().getName().equals("world") || p.getWorld().getName().equals("world_nether")
                || p.getWorld().getName().equals("world_the_end")) && !Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(Main.pre + " §cFor this you need §c§obuild §crights!");
        }
    }
}