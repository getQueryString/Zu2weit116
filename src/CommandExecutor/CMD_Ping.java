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
    public static CMD_Ping instance;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("ping"))
                if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")
                        || PermissionsEx.getUser(p).inGroup("Fellow")) {
                    if (args.length == 0) {
                        int ping = (((CraftPlayer) p).getHandle()).ping;
                        p.sendMessage(Main.pre + " §aDein Ping: §e" + ping + "ms.");
                    } else if (args.length >= 2) {
                        p.sendMessage("§bBenutze: §f/§cp§fing §a<Player>");
                    }
                    if (args.length == 1)
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
                } else {
                    p.sendMessage(Main.noperm);
                }
        } else if (cmd.getName().equalsIgnoreCase("ping")) {
            if (args.length == 0)
                Bukkit.getConsoleSender().sendMessage("§bBenutze: §f/§cp§fing §a<Player>");
            if (args.length == 1) {
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
        return false;
    }
}