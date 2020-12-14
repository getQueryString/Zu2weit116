// Copyright© by Fin

package CommandExecutor;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_HostAddress implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("ip"))
                if (PermissionsEx.getUser(p).inGroup("Owner")) {
                    if (args.length == 0) {
                        if (p.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                            p.sendMessage(main.pre + " §aDu bist local angemeldet: §e"
                                    + p.getAddress().getAddress().getHostAddress());
                        } else if (p.getAddress().getAddress().getHostAddress().startsWith("192.168")) {
                            p.sendMessage(main.pre + " §aDu bist im selben Netzwerk angemeldet: §e"
                                    + p.getAddress().getAddress().getHostAddress());
                        } else {
                            p.sendMessage(main.pre + " §aDeine IP-Adresse: §e"
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
                                    p.sendMessage(main.pre + " §aDu bist local angemeldet: §e"
                                            + p.getAddress().getAddress().getHostAddress());
                                } else if (t.getPlayer() == p.getPlayer()) {
                                    if (t.getAddress().getAddress().getHostAddress().startsWith("192.168")) {
                                        p.sendMessage(main.pre + " §aDu bist im selben Netzwerk angemeldet: §e"
                                                + p.getAddress().getAddress().getHostAddress());
                                    }
                                }
                            } else if (t.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                                p.sendMessage(main.pre + " §a" + t.getName() + " §aist local angemeldet: §e"
                                        + t.getAddress().getAddress().getHostAddress());
                            } else if (t.getAddress().getAddress().getHostAddress().startsWith("192.168")) {
                                p.sendMessage(
                                        main.pre + " §a" + t.getName() + " §aist im selben Netzwerk angemeldet: §e"
                                                + t.getAddress().getAddress().getHostAddress());
                            } else {
                                p.sendMessage(main.pre + " §a" + t.getName() + "'s IP-Adresse: §e"
                                        + t.getAddress().getAddress().getHostAddress());
                            }
                        } catch (NullPointerException e) {
                            p.sendMessage(main.pre + " §cSpieler nicht gefunden!");
                        }
                } else {
                    p.sendMessage(main.noperm);
                }
        } else if (cmd.getName().equalsIgnoreCase("ip")) {
            if (args.length == 0)
                Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/ip §a<Player>");
            if (args.length == 1) {
                try {
                    Player t = Bukkit.getServer().getPlayer(args[0]);
                    if (t.getAddress().getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                        Bukkit.getConsoleSender().sendMessage(main.pre + " §a" + t.getName()
                                + " §aist local angemeldet: §e" + t.getAddress().getAddress().getHostAddress());
                    } else if (t.getAddress().getAddress().getHostAddress().startsWith("192.168")) {
                        Bukkit.getConsoleSender()
                                .sendMessage(main.pre + " §a" + t.getName() + " §aist im selben Netzwerk angemeldet: §e"
                                        + t.getAddress().getAddress().getHostAddress());
                    } else {
                        Bukkit.getConsoleSender().sendMessage(main.pre + " §a" + t.getName() + "'s IP-Adresse: §e"
                                + t.getAddress().getAddress().getHostAddress());
                    }
                } catch (NullPointerException e) {
                    Bukkit.getConsoleSender().sendMessage(main.pre + " §cSpieler nicht gefunden!");
                }
            } else if (args.length >= 2) {
                Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/ip §a<Player>");
            }
        }
        return false;
    }
}
