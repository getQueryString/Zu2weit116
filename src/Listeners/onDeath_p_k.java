// Copyright© by Fin

package Listeners;

import Main.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDeath_p_k implements Listener {

    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        if (k != null) {
            e.setDeathMessage(
                    main.pre + "§e" + p.getName() + " §fwurde von §e" + k.getName() + " §fgetötet.");
        }
    }
}
