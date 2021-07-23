// Copyright© by Fin

package CommandExecutor;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class CMD_getPlayersOnWorlds implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (cmd.getName().equalsIgnoreCase("getplayers")) {
                sender.sendMessage("§cNumber of players:\n§aworld         §8: §c" + Bukkit.getWorld("world").getPlayers().size() + "\n" +
                        "§5world_nether  §8: §c" + Bukkit.getWorld("world_nether").getPlayers().size() + "\n" +
                        "§5world_the_end §8: §c" + Bukkit.getWorld("world_the_end").getPlayers().size());
            }
        } else {
            sender.sendMessage(Main.noperm);
        }
        return false;
    }
}