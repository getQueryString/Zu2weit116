// Copyright© by Fin

package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

@SuppressWarnings("deprecation")
public class PlayerPickupItem implements Listener {
    @EventHandler
    public void onPlayerPickUpItem(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (PermissionsEx.getUser(p).inGroup("default"))
            e.setCancelled(true);
    }
}