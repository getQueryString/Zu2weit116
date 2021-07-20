// Copyright© by Fin

package Main;

import CommandExecutor.*;
import Listeners.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getConsoleSender;

public class Main extends JavaPlugin implements Listener {

    // ArrayLists
    public static ArrayList<String> lore = new ArrayList<>();
    public static ArrayList<Player> allowedPlayer = new ArrayList<>();

    // HashMaps
    public static Map<UUID, EpicScoreboard> scoreboard = new HashMap<>();
    public static HashMap<Player, ArrayList<Integer>> pingPlayers = new HashMap<>();

    // Strings
    public static String noperm = "§7[§bZu2weit§7]  §4§lKeine Rechte!";
    public static String pre = "§7[§bZu2weit§7]";
    public static String join = "§a[+]";
    public static String leave = "§c[-]";
    public static String kick = "§4[-]";
    public static String iplayer = "§cDu musst ein Spieler sein!";
    public static String ccs = "§7| §4Only for the §bConsoleCommandSender";
    private static Main plugin;
    public static Main instance;

    public void onEnable() {
        plugin = this;
        Recipe.Recipe();
        instance = this;
        Autoshutdown as = new Autoshutdown(this);
        CreeperListener cl = new CreeperListener(this);
        CheckPing cp = new CheckPing(this);

        EVENT_PlayerJoin join = new EVENT_PlayerJoin();
        for (Player pl : Bukkit.getOnlinePlayers())
            join.onJoin(new PlayerJoinEvent(pl, ""));

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EVENT_PlayerJoin(), this);
        pm.registerEvents(new motd(), this);
        pm.registerEvents(new PlayerChatEvent(), this);
        pm.registerEvents(new SignListener(), this);
        pm.registerEvents(new JoinLeaveKick(), this);
        pm.registerEvents(new AntiBuild_Events(), this);
        pm.registerEvents(new onDeath(), this);
        pm.registerEvents(new PlayerPickupItem(), this);
        pm.registerEvents(new Whitelist_PlayerLogin(), this);
        pm.registerEvents(new BannedTitle(), this);
        pm.registerEvents(new Vektor(), this);
        pm.registerEvents(as, this);
        pm.registerEvents(cl, this);
        pm.registerEvents(cp, this);
        getCommand("ping").setExecutor(new CMD_Ping());
        getCommand("kopf").setExecutor(new CMD_Kopf());
        getCommand("clearchat").setExecutor(new CMD_ClearChat());
        getCommand("build").setExecutor(new AntiBuild());
        getCommand("stop").setExecutor(new CMD_Stop());
        getCommand("sharelocation").setExecutor(new CMD_ShareLocation());
        getCommand("loc").setExecutor(new CMD_LocationQuery());
        getCommand("ip").setExecutor(new CMD_HostAddress());
        getCommand("starttimer").setExecutor(as);
        getCommand("stoptimer").setExecutor(as);
        getCommand("rl").setExecutor(new CMD_Reload());
        getCommand("spypos").setExecutor(new CMD_SpyPos());

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
}