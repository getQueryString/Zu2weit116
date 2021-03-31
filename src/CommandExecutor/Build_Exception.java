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

public class Build_Exception implements Listener, CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("build-exception"))
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (PermissionsEx.getUser(p).inGroup("Owner")) {
                    if (args.length == 0) {
                        if (p.getWorld().getName().equals("world") || p.getWorld().getName().equals("world_nether")
                                || p.getWorld().getName().equals("world_the_end")) {
                            if (Main.allowedPlayer.contains(p)) {
                                Main.allowedPlayer.remove(p);
                                p.sendMessage(Main.pre + " §eBaumodus §cdeaktiviert§e!");
                                Bukkit.getConsoleSender().sendMessage(
                                        "§4" + p.getPlayer().getName() + " §ehat den Baumodus §cdeaktiviert§e!");
                            } else {
                                Main.allowedPlayer.add(p);
                                p.sendMessage(Main.pre + " §eException build mode §aenabled§e!");
                                Bukkit.getConsoleSender().sendMessage(
                                        "§4" + p.getPlayer().getName() + " §aenabled §ethe exception build mode!");
                            }
                        } else {
                            p.sendMessage(Main.pre + " §cDieser Command ist auf dieser Welt nicht gestattet!");
                            return true;
                        }
                    } else if (args.length >= 1) {
                        p.sendMessage("§bBenutze: §f/build-exception");
                    }
                } else {
                    p.sendMessage("§fUnbekannter Befehl");
                }
            } else {
                Bukkit.getServer().getConsoleSender().sendMessage(Main.iplayer);
            }
        return false;
    }
}