// Copyright© by Fin

package CommandExecutor;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_ClearChat implements Listener, CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")) {
                for (int i = 0; i < 105; i++) {
                    for (Player all : Bukkit.getOnlinePlayers())
                        all.sendMessage("");
                }
                Bukkit.broadcastMessage(
                        String.valueOf(main.pre) + " §7Der Chat wurde von §f§l" + p.getName() + " §7geleert.");
                return true;
            }
            p.sendMessage(main.noperm);
        } else {
            for (int i = 0; i < 105; i++) {
                for (Player all : Bukkit.getOnlinePlayers())
                    all.sendMessage("");
            }
            Bukkit.broadcastMessage(String.valueOf(main.pre) + " §7Der Chat wurde von §cConsole §7geleert.");
        }
        return false;
    }
}