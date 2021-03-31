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
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinLeaveKick implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (PermissionsEx.getUser(p).inGroup("Owner")) {
            p.sendMessage("");
            p.sendMessage("§cBitte warte nach dem Joinen und Respawnen etwas, bevor du die Welt erkundest!");
            p.sendMessage("");
            e.setJoinMessage(Main.join + " §4§l" + p.getName() + " §6ist dem Spiel beigetreten.");
        } else if (p.isOp()) {
            p.sendMessage("");
            p.sendMessage("§cBitte warte nach dem Joinen und Respawnen etwas, bevor du die Welt erkundest!");
            p.sendMessage("");
            e.setJoinMessage(Main.join + " §f§l" + p.getName() + " §6ist dem Spiel beigetreten.");
        } else if (PermissionsEx.getUser(p).inGroup("Vice")) {
            p.sendMessage("");
            p.sendMessage("§cBitte warte nach dem Joinen und Respawnen etwas, bevor du die Welt erkundest!");
            p.sendMessage("");
            e.setJoinMessage(Main.join + " §c" + p.getName() + " §6ist dem Spiel beigetreten.");
        } else if (PermissionsEx.getUser(p).inGroup("Fellow")) {
            p.sendMessage("");
            p.sendMessage("§cBitte warte nach dem Joinen und Respawnen etwas, bevor du die Welt erkundest!");
            p.sendMessage("");
            e.setJoinMessage(Main.join + " §5" + p.getName() + " §6ist dem Spiel beigetreten.");
        } else {
            p.sendMessage("");
            p.sendMessage("§cBitte warte nach dem Joinen und Respawnen etwas, bevor du die Welt erkundest!");
            p.sendMessage("");
            e.setJoinMessage(Main.join + " §8" + p.getName() + " §6ist dem Spiel beigetreten.");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (PermissionsEx.getUser(p).inGroup("Owner")) {
            e.setQuitMessage(Main.leave + " §4§l" + p.getName() + " §6hat das Spiel verlassen.");
        } else if (p.isOp()) {
            e.setQuitMessage(Main.leave + " §f§l" + p.getName() + " §6hat das Spiel verlassen.");
        } else if (PermissionsEx.getUser(p).inGroup("Vice")) {
            e.setQuitMessage(Main.leave + " §c" + p.getName() + " §6hat das Spiel verlassen.");
        } else if (PermissionsEx.getUser(p).inGroup("Fellow")) {
            e.setQuitMessage(Main.leave + " §5" + p.getName() + " §6hat das Spiel verlassen.");
        } else {
            e.setQuitMessage(Main.leave + " §8" + p.getName() + " §6hat das Spiel verlassen.");
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        if (PermissionsEx.getUser(p).inGroup("Owner")) {
            Bukkit.getConsoleSender()
                    .sendMessage(Main.kick + " §4§l" + p.getName() + " §cwurde aus dem Spiel geworfen.");
            e.setLeaveMessage(Main.kick + " §4§l" + p.getName() + " §cwurde aus dem Spiel geworfen.");
        } else if (p.isOp()) {
            Bukkit.getConsoleSender()
                    .sendMessage(Main.kick + " §f§l" + p.getName() + " §cwurde aus dem Spiel geworfen.");
            e.setLeaveMessage(Main.kick + " §f§l" + p.getName() + " §cwurde aus dem Spiel geworfen.");
        } else if (PermissionsEx.getUser(p).inGroup("Vice")) {
            Bukkit.getConsoleSender().sendMessage(Main.kick + " §c" + p.getName() + " §cwurde aus dem Spiel geworfen.");
            e.setLeaveMessage(Main.kick + " §f" + p.getName() + " §cwurde aus dem Spiel geworfen.");
        } else if (PermissionsEx.getUser(p).inGroup("Fellow")) {
            Bukkit.getConsoleSender().sendMessage(Main.kick + " §5" + p.getName() + " §cwurde aus dem Spiel geworfen.");
            e.setLeaveMessage(Main.kick + " §5" + p.getName() + " aus dem Spiel geworfen.");
        } else {
            Bukkit.getConsoleSender().sendMessage(Main.kick + " §8" + p.getName() + " §cwurde aus dem Spiel geworfen.");
            e.setLeaveMessage(Main.kick + " §8" + p.getName() + " §cwurde aus dem Spiel geworfen.");
        }
    }
}