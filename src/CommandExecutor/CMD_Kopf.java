// Copyright© by Fin

package CommandExecutor;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_Kopf implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")) {
                if (args.length == 1) {
                    ItemStack is = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta im = (SkullMeta) is.getItemMeta();
                    im.setOwningPlayer((OfflinePlayer) p.getPlayer());
                    im.setDisplayName("§c§n" + args[0]);
                    is.setItemMeta(im);
                    p.getInventory().addItem(new ItemStack[]{is});
                    p.updateInventory();
                    return true;
                }
                p.sendMessage("§bBenutze: §f/kopf§7, §f/head§7, §f/skull §a<Kopfname>");
                return true;
            }
            p.sendMessage(main.noperm);
            return true;
        }
        Bukkit.getConsoleSender().sendMessage(main.iplayer);
        return false;
    }
}
