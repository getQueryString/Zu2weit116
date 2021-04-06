// Copyright© by Fin

package CommandExecutor;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_Ping implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ping")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")
                        || PermissionsEx.getUser(p).inGroup("Fellow")) {
                    if (args.length == 0) {
                        int ping = (((CraftPlayer) p).getHandle()).ping;
                        p.sendMessage(Main.pre + " §aDein Ping: §e" + ping + "ms.");
                    } else if (args.length >= 2) {
                        p.sendMessage("§bBenutze: §f/§cp§fing §a<Player>");
                    }
                    if (args.length == 1) {//   /args[0] args[1] args[2] args[3]
                        try {
                            Player t = Bukkit.getServer().getPlayer(args[0]);
                            int ping = (((CraftPlayer) t).getHandle()).ping;
                            if (t.getPlayer() == p.getPlayer()) {
                                p.sendMessage(Main.pre + " §aDein Ping: §e" + ping + "ms.");
                            } else {
                                p.sendMessage(Main.pre + " §a" + t.getName() + "'s Ping: §e" + ping + "ms.");
                            }
                        } catch (NullPointerException e) {
                            p.sendMessage(Main.pre + " §cSpieler nicht gefunden!");
                        }
                    }
                } else {
                    p.sendMessage(Main.noperm);
                }
            } else {
                if (args.length == 0) {
                    Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/§cp§fing §a<Player>");
                } else if (args.length == 1) {
                    try {
                        Player t = Bukkit.getServer().getPlayer(args[0]);
                        int ping = (((CraftPlayer) t).getHandle()).ping;
                        Bukkit.getConsoleSender()
                                .sendMessage(Main.pre + " §a" + t.getName() + "'s Ping: §e" + ping + "ms.");
                    } catch (NullPointerException e) {
                        Bukkit.getConsoleSender().sendMessage(Main.pre + " §cSpieler nicht gefunden!");
                    }
                } else if (args.length >= 2) {
                    Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/§cp§fing §a<Player>");
                }
            }
        }
        return false;
    }
}
