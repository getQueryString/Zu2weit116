// Copyright© by Fin

package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        msg.replace("%", "Prozent");
        if (PermissionsEx.getUser(p).inGroup("default"))
            e.setFormat("§8Spieler | " + p.getName() + " §8| §f" + msg);
        if (PermissionsEx.getUser(p).inGroup("Fellow"))
            e.setFormat("§5Fellow | " + p.getName() + " §8| §f" + msg);
        if (PermissionsEx.getUser(p).inGroup("Vice"))
            e.setFormat("§cVice | " + p.getName() + " §8| §e" + msg);
        if (PermissionsEx.getUser(p).inGroup("Owner"))
            e.setFormat("§4§lChief | " + p.getName() + " §8| §a§l" + msg);
        if (p.isOp())
            e.setFormat("§f§lOperator | §4§l" + p.getName() + " §8| §a§l" + msg);
    }
}