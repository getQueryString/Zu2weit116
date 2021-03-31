// Copyright© by Fin   Rares <3

package Main;

import CommandExecutor.*;
import Listeners.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getConsoleSender;

public class Main extends JavaPlugin implements Listener {

    // ArrayLists
    public static ArrayList<String> lore = new ArrayList<>();
    public static ArrayList<Player> allowedPlayer = new ArrayList<>();

    // HashMaps
    public static Map<UUID, EpicScoreboard> scoreboard = new HashMap<>();
    private static HashMap<Player, ArrayList<Integer>> pingPlayers = new HashMap<>();

    // Strings
    public static String noperm = "§7[§bZu2weit§7]  §4§lKeine Rechte!";
    public static String pre = "§7[§bZu2weit§7]";
    public static String fix = "§7[§eBugFixes§7]§f: ";
    public static String bug = "§7[§cBugs§7]§f: ";
    public static String join = "§a[+]";
    public static String leave = "§c[-]";
    public static String kick = "§4[-]";
    public static String iplayer = "§cDu musst ein Spieler sein!";
    private static Main plugin;
    public static Main instance;
    public static String world = "world";
    public static String world_nether = "world_nether";
    public static String world_the_end = "world_the_end";

    public void onEnable() {
        plugin = this;
        Recipe.Recipe();
        instance = this;
        Autoshutdown as = new Autoshutdown(this);

        EVENT_PlayerJoin join = new EVENT_PlayerJoin();
        for (Player pl : Bukkit.getOnlinePlayers())
            join.onJoin(new PlayerJoinEvent(pl, ""));

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EVENT_PlayerJoin(), this);
        pm.registerEvents(new motd(), this);
        pm.registerEvents(new PlayerChatEvent(), this);
        pm.registerEvents(new SignListener(), this);
        pm.registerEvents(new JoinLeaveKick(), this);
        pm.registerEvents(new onBreak_onPlace(), this);
        pm.registerEvents(new onDeath_p_k(), this);
        pm.registerEvents(new PlayerPickupItem(), this);
        pm.registerEvents(new onDrop_EVENT(), this);
        pm.registerEvents(new PlayerInteract_EVENT(), this);
        pm.registerEvents(new Whitelist_PlayerLogin(), this);
        pm.registerEvents(new BannedTitle(), this);
        pm.registerEvents(as, this);
        getCommand("ping").setExecutor(new CMD_Ping());
        getCommand("kopf").setExecutor(new CMD_Kopf());
        getCommand("clearchat").setExecutor(new CMD_ClearChat());
        getCommand("build").setExecutor(new AntiBuild());
        getCommand("build-exception").setExecutor(new Build_Exception());
        getCommand("stop").setExecutor(new CMD_Stop());
        getCommand("lastfix").setExecutor(new CMD_LastFix());
        getCommand("sharelocation").setExecutor(new CMD_ShareLocation());
        getCommand("loc").setExecutor(new CMD_LocationQuery());
        getCommand("ip").setExecutor(new CMD_HostAddress());
        getCommand("starttimer").setExecutor(as);
        getCommand("stoptimer").setExecutor(as);

        startRunnableHighPlayerPing();
        teleportCreeper();

        getConsoleSender().sendMessage("§aDas §3Zu2weit-Plugin §awurde erfolgreich aktiviert!");
        if (Bukkit.getOnlinePlayers().size() == 0) {
            Bukkit.getConsoleSender().sendMessage("§cThe server will shut down in 5 minutes because there are no players on the server");
        }
    }

    public void onDisable() {
        getConsoleSender().sendMessage("§4Das §3Zu2weit-Plugin §4wurde erfolgreich deaktiviert!");
    }

    public static Main getPlugin() {
        return plugin;
    }

    /*
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/version")
                || e.getMessage().toLowerCase().startsWith("/ver") || e.getMessage().toLowerCase().startsWith("/help")
                || e.getMessage().toLowerCase().startsWith("/pex") || e.getMessage().toLowerCase().startsWith("/?")
                || e.getMessage().toLowerCase().startsWith("/ban") || e.getMessage().toLowerCase().startsWith("/pardon")
                || e.getMessage().toLowerCase().startsWith("/kick") || e.getMessage().toLowerCase().startsWith("/me")
                || e.getMessage().toLowerCase().startsWith("/tell") || e.getMessage().toLowerCase().startsWith("/msg")
                || e.getMessage().toLowerCase().startsWith("/about") || e.getMessage().toLowerCase().startsWith("/vv")
                || e.getMessage().toLowerCase().startsWith("/demote") || e.getMessage().toLowerCase().startsWith("/via")
                || e.getMessage().toLowerCase().startsWith("/spigot:") || e.getMessage().toLowerCase().startsWith("/ip")
                || e.getMessage().toLowerCase().startsWith("/stop") || e.getMessage().toLowerCase().startsWith("/w")
                || e.getMessage().toLowerCase().startsWith("/promote")
                || e.getMessage().toLowerCase().startsWith("/icanhasbukkit")
                || e.getMessage().toLowerCase().startsWith("/minecraft")
                || e.getMessage().toLowerCase().startsWith("/trigger")
                || e.getMessage().toLowerCase().startsWith("/bukkit:")) {
            if (!PermissionsEx.getUser(p).inGroup("Owner")) {
                e.setCancelled(true);
                p.sendMessage(noperm);
                return;
            }
        }
    }*/

    // From another source
    // Check Ping
    private void startRunnableHighPlayerPing() {
        new BukkitRunnable() {

            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    // Wenn der Spieler in der letzen Abfrage über 1000ms hat
                    if (pingPlayers.containsKey(p)) {
                        // Holt die letzten Pings, die der Spieler hatte
                        ArrayList<Integer> lastPings = pingPlayers.get(p);

                        // Holt den letzen Ping, den der Spieler hatte
                        int lastPing = lastPings.get(lastPings.size());
                        // Holt den derzeitigen Ping, den der Spieler hat
                        int currentPing = getPing(p);

                        // Wenn 15 Pings eingetragen sind
                        if (lastPings.size() >= 15) {
                            // Ob letzer & derzeitiger Ping >= 800ms ist
                            if (lastPing >= 800 && currentPing >= 800) {
                                // Löscht den Spieler aus dem Zwischenspeicher
                                pingPlayers.remove(p);
                                p.kickPlayer("§cDein Ping war im vorgegebenen Zeitraum mit §e" + getPing(p) + "ms §czu hoch");
                                continue;
                            }
                        }
                        // Ob letzer Ping >= 800ms war
                        if (lastPing >= 800) {
                            // Ob derzeitiger Ping >= 800ms ist
                            if (currentPing >= 800) {
                                // Fügt den derzeitigen Ping zur Liste hinzu
                                lastPings.add(currentPing);

                                // Update für die HashMap
                                pingPlayers.remove(p);
                                pingPlayers.put(p, lastPings);
                            } else {
                                // Wenn nicht, wird der Spieler aus dem Zwischenspeicher gelöscht
                                pingPlayers.remove(p);
                            }
                        }
                    } else {
                        // Wenn nicht, wird der derzeitige Ping abgefragt
                        int currentPing = getPing(p);

                        // Ob derzeitiger Ping >= 500ms
                        if (currentPing >= 500) {
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1F, 1F);
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1F, 1F);
                            p.sendMessage("§4§lACHTUNG: §4Hoher Ping!: §e" + getPing(p) + "ms.");
                            getConsoleSender().sendMessage("§f" + p.getName() + "'s §4current Ping: §e" + getPing(p) + "ms.");
                        } else if (currentPing >= 800) {
                            ArrayList<Integer> pings = new ArrayList<>();

                            // Wenn ja, wird der Spieler zum Zwischenspeicher hinzugefügt
                            pings.add(currentPing);
                            pingPlayers.put(p, pings);
                        }
                    }
                }
            }

        }.runTaskTimer((Plugin) this, 0, 60);
    }

    private int getPing(Player p) {
        try {
            Object entityPlayer = p.getClass().getMethod("getHandle").invoke(p);
            return (int) entityPlayer.getClass().getField("ping").get(entityPlayer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // teleport Creepers
    private void teleportCreeper() {
        new BukkitRunnable() {

            @Override
            public void run() {

                if (Bukkit.getOnlinePlayers().size() >= 1) {
                    getServer().dispatchCommand(getConsoleSender(), "tp @e[type=creeper] ~ -2 ~");
                }
            }
        }.runTaskTimer((Plugin) this, 1200, 1200);
    }
}