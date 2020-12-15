// Help from https://www.gutefrage.net/nutzer/Tobihogh/

package Listeners;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Autoshutdown implements Listener, CommandExecutor {

    Plugin context;
    BukkitRunnable timer = null;
    boolean enabled = true;
    int minutes = 5;

    public Autoshutdown(Plugin plugin) {
        this.context = plugin;

        if (Bukkit.getOnlinePlayers().size() == 0) {
            startTimer();
        }
    }

    public void startTimer() {
        this.timer = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.shutdown();
            }
        };
        timer.runTaskLater(context, 20 * 60 * 5);
        Bukkit.getConsoleSender().sendMessage("§cServer will shut down in 5 minutes because there are no players on the server");
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            Bukkit.getConsoleSender().sendMessage("§cTimer stopped because the server is not empty");
        }
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent e) {
        if (enabled && Bukkit.getOnlinePlayers().size() <= 1) {
            startTimer();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        stopTimer();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        /*Player p = (Player) sender;
        if (sender instanceof ConsoleCommandSender) {
            if (cmd.getName().equalsIgnoreCase("stoptimer")) {
                if (!enabled) {
                    stopTimer();
                    Bukkit.getConsoleSender().sendMessage("§cTimer wurde gestoppt");
                } else {
                    Bukkit.getConsoleSender().sendMessage("§cBereits gestoppt");
                }
            }
            if (cmd.getName().equalsIgnoreCase("starttimer")) {
                if (enabled) {
                    startTimer();
                    Bukkit.getConsoleSender().sendMessage("§cTimer wurde gestartet");
                }else{
                    Bukkit.getConsoleSender().sendMessage("§cBereits gestartet");
                }
            }
        } else {
            p.sendMessage(main.iplayer);

        }*/
        return false;
    }

}