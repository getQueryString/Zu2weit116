// Copyright© by Fin

package Listeners;

import Main.main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDeath_p_k implements Listener {
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        if (k != null) {
            e.setDeathMessage(
                    main.pre + " §fDer Spieler §6" + p.getName() + " §fwurde von §c" + k.getName() + " §fget§tet.");
        } else {
            e.setDeathMessage("§fDer Spieler §6" + p.getName() + " §fist gestorben.");
        }
    }
}
