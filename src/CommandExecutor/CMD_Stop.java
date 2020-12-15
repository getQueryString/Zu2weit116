// Copyright© by Fin

package CommandExecutor;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_Stop implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof ConsoleCommandSender) {
            if (cmd.getName().equalsIgnoreCase("stop")) {
                for (int i = 3; i > 0; i--) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        Bukkit.broadcastMessage(
                                "§8| §4Server§f-§4shutdown in§8: §e" + i + " Sekunde(n) §f| §cBitte nicht verlassen!");
                        all.playSound(all.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 50.0F);
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Bukkit.shutdown();
            }
        } else if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")) {
            Bukkit.getConsoleSender().sendMessage("§4! §e" + p.getPlayer().getName() + " tried to stop the server");
            p.sendMessage("§7| §4Only for the §bConsoleCommandSender");
        } else {
            p.sendMessage(main.noperm);
        }
        return false;
    }
}