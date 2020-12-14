// Copyright© by Fin

package Listeners;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperListener implements Listener {
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        if (e.getEntity() instanceof Creeper) {
            float eP = 1.5F;
            e.setCancelled(true);
            e.getLocation().getWorld().createExplosion(e.getLocation(), eP);
        }
    }

}
