// Copyright© by Fin

package CommandExecutor;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CMD_ShareLocation implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("sharelocation"))
                if (PermissionsEx.getUser(p).inGroup("Owner") || PermissionsEx.getUser(p).inGroup("Vice")
                        || PermissionsEx.getUser(p).inGroup("Fellow") || p.isOp()) {
                    double coordX = p.getLocation().getX();
                    double coordY = p.getLocation().getY();
                    double coordZ = p.getLocation().getZ();
                    double X = Math.round(coordX * 100.0D) / 100.0D;
                    double Y = Math.round(coordY * 100.0D) / 100.0D;
                    double Z = Math.round(coordZ * 100.0D) / 100.0D;
                    if (PermissionsEx.getUser(p).inGroup("Owner"))
                        if (p.getWorld().getName().equalsIgnoreCase("world")) {
                            Bukkit.broadcastMessage("§7[§4§l" + p.getName() + "§7]\n§a" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_nether")) {
                            Bukkit.broadcastMessage("§7[§4§l" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                            Bukkit.broadcastMessage("§7[§4§l" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        }
                    if (p.isOp())
                        if (p.getWorld().getName().equalsIgnoreCase("world")) {
                            Bukkit.broadcastMessage("§7[§0§l" + p.getName() + "§7]\n§a" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_nether")) {
                            Bukkit.broadcastMessage("§7[§0§l" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                            Bukkit.broadcastMessage("§7[§0§l" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        }
                    if (PermissionsEx.getUser(p).inGroup("Vice"))
                        if (p.getWorld().getName().equalsIgnoreCase("world")) {
                            Bukkit.broadcastMessage("§7[§c" + p.getName() + "§7]\n§a" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_nether")) {
                            Bukkit.broadcastMessage("§7[§c" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                            Bukkit.broadcastMessage("§7[§c" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        }
                    if (PermissionsEx.getUser(p).inGroup("Fellow"))
                        if (p.getWorld().getName().equalsIgnoreCase("world")) {
                            Bukkit.broadcastMessage("§7[§5" + p.getName() + "§7]\n§a" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_nether")) {
                            Bukkit.broadcastMessage("§7[§5" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        } else if (p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                            Bukkit.broadcastMessage("§7[§5" + p.getName() + "§7]\n§5" + p.getWorld().getName()
                                    + "§7» §fX:§7" + X + " §fY:§7" + Y + " §fZ:§7" + Z);
                        }
                } else {
                    p.sendMessage(main.noperm);
                }
        } else {
            Bukkit.getConsoleSender().sendMessage(main.iplayer);
        }
        return false;
    }
}