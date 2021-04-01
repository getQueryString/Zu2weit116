// Copyright© by Fin

package CommandExecutor;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_ClearChat implements Listener, CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            boolean permexo = PermissionsEx.getUser(p).inGroup("Owner");
            boolean permexv = PermissionsEx.getUser(p).inGroup("Vice");
            if (permexo || permexv || p.isOp()) {
                for (int i = 0; i < 105; i++) {
                    for (Player all : Bukkit.getOnlinePlayers())
                        all.sendMessage("");
                }
                if (p.isOp()) {
                    Bukkit.broadcastMessage(
                            Main.pre + " §7Der Chat wurde von §f§l" + p.getName() + " §7geleert.");
                } else if (permexo) {
                    Bukkit.broadcastMessage(
                            Main.pre + " §7Der Chat wurde von §4§l" + p.getName() + " §7geleert.");
                } else {
                    Bukkit.broadcastMessage(
                            Main.pre + " §7Der Chat wurde von §c" + p.getName() + " §7geleert.");
                }
                return true;
            }
            p.sendMessage(Main.noperm);
        } else {
            for (int i = 0; i < 105; i++) {
                for (Player all : Bukkit.getOnlinePlayers())
                    all.sendMessage("");
            }
            Bukkit.broadcastMessage(Main.pre + " §7Der Chat wurde von §bConsole §7geleert.");
        }
        return false;
    }
}