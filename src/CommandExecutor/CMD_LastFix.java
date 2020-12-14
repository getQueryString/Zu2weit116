// Copyright© by Fin

package CommandExecutor;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_LastFix implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage("");
            Bukkit.getConsoleSender()
                    .sendMessage(main.fix + "Error from §aListeners.PlayerPickupItem.java\n§ffixed in §92.0.10");
            Bukkit.getConsoleSender()
                    .sendMessage(main.fix + "Some errors in classes with §ainstanceof\n§ffixed in §92.0.13");
            Bukkit.getConsoleSender().sendMessage(main.fix + "Ping command error\n§ffixed in §92.0.15");
        } else {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("lastfix"))
                if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")) {
                    p.sendMessage("");
                    p.sendMessage(main.fix + "Error from §aListeners.PlayerPickupItem.java\n§ffixed in §92.0.10");
                    p.sendMessage(main.fix + "Some errors in classes with §ainstanceof\n§ffixed in §92.0.13");
                    p.sendMessage(main.fix + "Ping command error\n§ffixed in §92.0.15");
                } else {
                    p.sendMessage(main.noperm);
                }
        }
        return false;
    }
}
