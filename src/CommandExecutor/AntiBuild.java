// Copyright© by Fin

package CommandExecutor;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class AntiBuild implements Listener, CommandExecutor {
    public AntiBuild() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                int onlinePlayers = Bukkit.getOnlinePlayers().size();
                if (!PermissionsEx.getUser(p).inGroup("Owner") && !PermissionsEx.getUser(p).inGroup("Vice") && !PermissionsEx.getUser(p).inGroup("Fellow")) {
                    sender.sendMessage(Main.noperm);
                } else if (args.length == 0) {
                    if (!p.getWorld().getName().equals("world") && !p.getWorld().getName().equals("world_nether") && !p.getWorld().getName().equals("world_the_end")) {
                        p.sendMessage(Main.pre + " §cDieser Command ist auf dieser Welt nicht gestattet!");
                        return true;
                    }

                    if (Main.allowedPlayer.contains(p)) {
                        Main.allowedPlayer.remove(p);
                        p.sendMessage(Main.pre + " §eBaumodus §cdeaktiviert§e!");
                        if (PermissionsEx.getUser(p).inGroup("Owner")) {
                            Bukkit.getConsoleSender().sendMessage("§4" + p.getPlayer().getName() + " §ehat den Baumodus §cdeaktiviert§e!");
                        } else if (PermissionsEx.getUser(p).inGroup("Vice")) {
                            Bukkit.getConsoleSender().sendMessage("§c" + p.getPlayer().getName() + " §ehat den Baumodus §cdeaktiviert§e!");
                        } else if (PermissionsEx.getUser(p).inGroup("Fellow")) {
                            Bukkit.getConsoleSender().sendMessage("§5" + p.getPlayer().getName() + " §ehat den Baumodus §cdeaktiviert§e!");
                        }
                    } else if (onlinePlayers > 1) {
                        Main.allowedPlayer.add(p);
                        p.sendMessage(Main.pre + " §eBaumodus §aaktiviert§e!");
                        if (PermissionsEx.getUser(p).inGroup("Owner")) {
                            Bukkit.getConsoleSender().sendMessage("§4" + p.getPlayer().getName() + " §ehat den Baumodus §aaktiviert§e!");
                        } else if (PermissionsEx.getUser(p).inGroup("Vice")) {
                            Bukkit.getConsoleSender().sendMessage("§c" + p.getPlayer().getName() + " §ehat den Baumodus §aaktiviert§e!");
                        } else if (PermissionsEx.getUser(p).inGroup("Fellow")) {
                            Bukkit.getConsoleSender().sendMessage("§5" + p.getPlayer().getName() + " §ehat den Baumodus §aaktiviert§e!");
                        }
                    } else {
                        p.sendMessage(Main.pre + " §4Nicht genug Spieler!");
                    }
                } else if (args.length >= 1) {
                    sender.sendMessage("§bBenutze: §f/§cb§fuild");
                }
            } else {
                Bukkit.getServer().getConsoleSender().sendMessage(Main.iplayer);
            }
        }

        return false;
    }
}