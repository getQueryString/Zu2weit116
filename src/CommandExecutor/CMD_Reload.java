// Copyright© by Fin

package CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_Reload implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender || sender.isOp()) {
            if (cmd.getName().equalsIgnoreCase("rl")) {
                if (Bukkit.getOnlinePlayers().size() >= 1) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        sender.sendMessage(Main.Main.pre + " §cReloading...");
                        if (all.hasPermission("zz.see.reload")) {
                            all.sendMessage(Main.Main.pre + " §cReloading...");
                        }
                    }
                } else if (Bukkit.getOnlinePlayers().size() == 0) {
                    sender.sendMessage(Main.Main.pre + " §cReloading...");
                }
                Bukkit.reload();
                if (Bukkit.getOnlinePlayers().size() >= 1) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.hasPermission("zz.see.reload")) {
                            all.sendMessage(Main.Main.pre + " §aReload complete.");
                        }
                        sender.sendMessage(Main.Main.pre + " §aReload complete.");
                    }
                } else if (Bukkit.getOnlinePlayers().size() == 0) {
                    sender.sendMessage(Main.Main.pre + " §aReload complete.");
                }
            }
        } else {
            Player p = (Player) sender;
            if (!PermissionsEx.getUser(p).inGroup("Owner")) {
                sender.sendMessage(Main.Main.noperm);
            } else {
                p.sendMessage(Main.Main.ccs);
            }
        }
        return false;
    }
}