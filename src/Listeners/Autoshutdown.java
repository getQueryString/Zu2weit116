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
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Autoshutdown implements Listener, CommandExecutor {

    Plugin context;
    BukkitRunnable timer = null;
    boolean enabled = true;

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
        if (enabled && timer != null && Bukkit.getOnlinePlayers().size() <= 1) {
            Bukkit.getConsoleSender().sendMessage("§cServer will shut down in 5 minutes because there are no players on the server");
        }else if (enabled && timer != null && Bukkit.getOnlinePlayers().size() == 0) {
        }
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            if (timer == null && Bukkit.getOnlinePlayers().size() == 0) {
            } else if (timer == null && Bukkit.getOnlinePlayers().size() >= 1) {
                Bukkit.getConsoleSender().sendMessage("§cTimer stopped because the server is not empty");
            }
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
        if (sender instanceof ConsoleCommandSender) {
            switch (label) {
                case "starttimer":
                    if (timer != null) {
                        sender.sendMessage("§cThe timer is already running");
                    } else if (Bukkit.getOnlinePlayers().size() == 0) {
                        enabled = true;
                        startTimer();
                        sender.sendMessage("§cThe timer has started");
                    } else if (Bukkit.getOnlinePlayers().size() >= 1) {
                        sender.sendMessage("§cTimer could not be started because there are players on the server");
                    }
                    break;
                case "stoptimer":
                    if (timer == null) {
                        sender.sendMessage("§cThe timer does not run");
                    } else {
                        enabled = false;
                        stopTimer();
                        sender.sendMessage("§cThe timer was interrupted");
                    }
                    break;
            }
        } else if (PermissionsEx.getUser((Player) sender).inGroup("Owner")) {
            sender.sendMessage("§7| §4Only for the §bConsoleCommandSender");
        } else {
            sender.sendMessage(main.noperm);
        }

        return false;
    }
}