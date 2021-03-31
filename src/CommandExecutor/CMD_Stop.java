// Copyright© by Fin

package CommandExecutor;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_Stop implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (cmd.getName().equalsIgnoreCase("stop")) {
                Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask((Plugin) this, new Runnable() {
                    int count = 3;

                    public void run() {
                        if (count >= 1) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                Bukkit.broadcastMessage(
                                        "§8| §4Server§f-§4shutdown in§8: §e" + count + " Sekunde(n) §f| §cBitte nicht verlassen!");
                                all.playSound(all.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 50.0F);
                                count--;
                            }
                        }
                    }
                }, 0, 20);
                sender.sendMessage("Bukkit.shutdown();");
            }
        } else if (PermissionsEx.getUser((Player) sender).inGroup("Owner") || PermissionsEx.getUser((Player) sender).inGroup("Vice")) {
            Bukkit.getConsoleSender().sendMessage("§4! §e" + sender.getName() + " tried to stop the server");
            sender.sendMessage("§7| §4Only for the §bConsoleCommandSender");
        } else {
            sender.sendMessage(Main.noperm);
        }
        return false;
    }
}