// Copyright© by Fin

package CommandExecutor;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_HostAddress implements CommandExecutor {

    String color = null;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ip")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (PermissionsEx.getUser(p).inGroup("Owner")) {
                    if (args.length == 0) {
                        if (p.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                            p.sendMessage(Main.pre + " §aDu bist lokal angemeldet: §e"
                                    + p.getAddress().getAddress().getHostAddress());
                        } else if (p.getAddress().getAddress().getHostAddress().startsWith("192.168")) {
                            p.sendMessage(Main.pre + " §aDu bist im selben Netzwerk angemeldet: §e"
                                    + p.getAddress().getAddress().getHostAddress());
                        } else {
                            p.sendMessage(Main.pre + " §aDeine IP-Adresse: §e"
                                    + p.getAddress().getAddress().getHostAddress());
                        }
                    } else if (args.length >= 2) {
                        p.sendMessage("§bBenutze: §f/ip §a<Player>");
                    }
                    if (args.length == 1)
                        try {
                            Player t = Bukkit.getServer().getPlayer(args[0]);
                            if (t.getPlayer() == p.getPlayer()) {
                                if (t.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                                    p.sendMessage(Main.pre + " §aDu bist lokal angemeldet: §e"
                                            + p.getAddress().getAddress().getHostAddress());
                                } else if (t.getPlayer() == p.getPlayer()) {
                                    if (t.getAddress().getAddress().getHostAddress().startsWith("192.168")) {
                                        p.sendMessage(Main.pre + " §aDu bist im selben Netzwerk angemeldet: §e"
                                                + p.getAddress().getAddress().getHostAddress());
                                    }
                                }
                            } else if (t.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {

                                PermissionUser user = PermissionsEx.getUser(t);
                                if (user.inGroup("Owner")) color = "§4§l";
                                else if (user.inGroup("Vice")) color = "§c";
                                else if (user.inGroup("Fellow")) color = "§5";
                                else if (user.inGroup("default")) color = "§8";

                                if (color != null) {
                                    p.sendMessage(Main.pre + " " + color + t.getName() + " §aist lokal angemeldet: §e" + t.getAddress().getAddress().getHostAddress());
                                }
                            } else if (t.getAddress().getAddress().getHostAddress().startsWith("192.168")) {

                                PermissionUser user = PermissionsEx.getUser(t);
                                if (user.inGroup("Owner")) color = "§4§l";
                                else if (user.inGroup("Vice")) color = "§c";
                                else if (user.inGroup("Fellow")) color = "§5";
                                else if (user.inGroup("default")) color = "§8";

                                if (color != null) {
                                    p.sendMessage(Main.pre + " " + color + t.getName() + " §aist im selben Netzwerk angemeldet: §e" + t.getAddress().getAddress().getHostAddress());
                                }
                            } else {

                                PermissionUser user = PermissionsEx.getUser(t);
                                if (user.inGroup("Owner")) color = "§4§l";
                                else if (user.inGroup("Vice")) color = "§c";
                                else if (user.inGroup("Fellow")) color = "§5";
                                else if (user.inGroup("default")) color = "§8";

                                if (color != null) {
                                    p.sendMessage(Main.pre + " " + color + t.getName() + "§a's IP-Adresse: §e" + t.getAddress().getAddress().getHostAddress());
                                }
                            }
                        } catch (NullPointerException e) {
                            p.sendMessage(Main.pre + " §cSpieler nicht gefunden!");
                        }
                } else {
                    p.sendMessage(Main.noperm);
                }
            } else {
                if (args.length == 0)
                    Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/ip §a<Player>");
                if (args.length == 1) {
                    try {
                        Player t = Bukkit.getServer().getPlayer(args[0]);
                        if (t.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {

                            PermissionUser user = PermissionsEx.getUser(t);
                            if (user.inGroup("Owner")) color = "§4§l";
                            else if (user.inGroup("Vice")) color = "§c";
                            else if (user.inGroup("Fellow")) color = "§5";
                            else if (user.inGroup("default")) color = "§8";

                            if (color != null) {
                                Bukkit.getConsoleSender().sendMessage(Main.pre + " " + color + t.getName() + " §aist lokal angemeldet: §e" + t.getAddress().getAddress().getHostAddress());
                            }
                        } else if (t.getAddress().getAddress().getHostAddress().startsWith("192.168")) {

                            PermissionUser user = PermissionsEx.getUser(t);
                            if (user.inGroup("Owner")) color = "§4§l";
                            else if (user.inGroup("Vice")) color = "§c";
                            else if (user.inGroup("Fellow")) color = "§5";
                            else if (user.inGroup("default")) color = "§8";

                            if (color != null) {
                                Bukkit.getConsoleSender().sendMessage(Main.pre + " " + color + t.getName() + " §aist im selben Netzwerk angemeldet: §e" + t.getAddress().getAddress().getHostAddress());
                            }
                        } else {

                            PermissionUser user = PermissionsEx.getUser(t);
                            if (user.inGroup("Owner")) color = "§4§l";
                            else if (user.inGroup("Vice")) color = "§c";
                            else if (user.inGroup("Fellow")) color = "§5";
                            else if (user.inGroup("default")) color = "§8";

                            if (color != null) {
                                Bukkit.getConsoleSender().sendMessage(Main.pre + " " + color + t.getName() + "§a's IP-Adresse: §e" + t.getAddress().getAddress().getHostAddress());
                            }
                        }
                    } catch (NullPointerException e) {
                        Bukkit.getConsoleSender().sendMessage(Main.pre + " §cSpieler nicht gefunden!");
                    }
                } else if (args.length >= 2) {
                    Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/ip §a<Player>");
                }
            }
        }
        return false;
    }
}