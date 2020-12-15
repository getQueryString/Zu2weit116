// Copyright© by Fin

package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BannedTitle implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (p.isBanned())
            e.setKickMessage(
                    "§cDu wurdest §4PERMANENT §cvom Server gebannt\n\n§aDu kannst §4§lKEINEN §aEntbannungsantrag stellen.");
    }
}