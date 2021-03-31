// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class EVENT_PlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player pl = e.getPlayer();
        new EpicScoreboard(pl).sendToPlayer(pl);
        if (PermissionsEx.getUser(pl).inGroup("Owner")) {
            for (Player p : Bukkit.getOnlinePlayers())
                Main.scoreboard.get(p.getUniqueId()).sb.getTeam("002owner").addEntry(pl.getName());
        } else if (pl.isOp()) {
            for (Player p : Bukkit.getOnlinePlayers())
                Main.scoreboard.get(p.getUniqueId()).sb.getTeam("001op").addEntry(pl.getName());
        } else if (PermissionsEx.getUser(pl).inGroup("Vice")) {
            for (Player p : Bukkit.getOnlinePlayers())
                Main.scoreboard.get(p.getUniqueId()).sb.getTeam("003vice").addEntry(pl.getName());
        } else if (PermissionsEx.getUser(pl).inGroup("Fellow")) {
            for (Player p : Bukkit.getOnlinePlayers())
                Main.scoreboard.get(p.getUniqueId()).sb.getTeam("004fellow").addEntry(pl.getName());
        } else {
            for (Player p : Bukkit.getOnlinePlayers())
                Main.scoreboard.get(p.getUniqueId()).sb.getTeam("005spieler").addEntry(pl.getName());
        }
    }
}