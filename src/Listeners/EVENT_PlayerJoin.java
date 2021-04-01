// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.Collection;
import java.util.Objects;

public class EVENT_PlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player pl = e.getPlayer();
        PermissionUser permex = PermissionsEx.getUser(pl);
        Collection<? extends Player> opl = Bukkit.getOnlinePlayers();
        new EpicScoreboard(pl).sendToPlayer(pl);
        if (permex.inGroup("Owner")) {
            for (Player p : opl)
                Objects.requireNonNull(Main.scoreboard.get(p.getUniqueId()).sb.getTeam("002owner")).addEntry(pl.getName());
        } else if (pl.isOp()) {
            for (Player p : opl)
                Objects.requireNonNull(Main.scoreboard.get(p.getUniqueId()).sb.getTeam("001op")).addEntry(pl.getName());
        } else if (permex.inGroup("Vice")) {
            for (Player p : opl)
                Objects.requireNonNull(Main.scoreboard.get(p.getUniqueId()).sb.getTeam("003vice")).addEntry(pl.getName());
        } else if (permex.inGroup("Fellow")) {
            for (Player p : opl)
                Objects.requireNonNull(Main.scoreboard.get(p.getUniqueId()).sb.getTeam("004fellow")).addEntry(pl.getName());
        } else {
            for (Player p : opl)
                Objects.requireNonNull(Main.scoreboard.get(p.getUniqueId()).sb.getTeam("005spieler")).addEntry(pl.getName());
        }
    }
}