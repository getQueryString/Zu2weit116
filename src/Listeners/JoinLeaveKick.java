// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinLeaveKick implements Listener {

    String color = null;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("Owner")) color = "§4§l";
        else if (user.inGroup("Vice")) color = "§c";
        else if (user.inGroup("Fellow")) color = "§5";
        else if (user.inGroup("default")) color = "§8";

        if (color != null) {
            p.sendMessage("");
            e.setJoinMessage(Main.join + " " + color + p.getName() + " §6ist dem Spiel beigetreten.");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("Owner")) color = "§4§l";
        else if (user.inGroup("Vice")) color = "§c";
        else if (user.inGroup("Fellow")) color = "§5";
        else if (user.inGroup("default")) color = "§8";

        if (color != null) {
            e.setQuitMessage(Main.leave + " " + color + p.getName() + " §6hat das Spiel verlassen.");
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        PermissionUser user = PermissionsEx.getUser(p);
        if (user.inGroup("Owner")) color = "§4§l";
        else if (user.inGroup("Vice")) color = "§c";
        else if (user.inGroup("Fellow")) color = "§5";
        else if (user.inGroup("default")) color = "§8";

        if (color != null) {
            Bukkit.getConsoleSender().sendMessage(Main.kick + " " + color + p.getName() + " §cwurde aus dem Spiel geworfen.");
            e.setLeaveMessage(Main.kick + " " + color + p.getName() + " §cwurde aus dem Spiel geworfen.");
        }
    }
}