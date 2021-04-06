// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.Tripwire;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.scheduler.BukkitTask;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.List;

public class AntiBuild_Interacts implements Listener {

    // Break
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(Main.pre + " §cProtected!");
        }
    }

    // Place
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
            p.sendMessage(Main.pre + " §cProtected!");
        }
    }

    // EntityDamageByEntity
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            if (!Main.allowedPlayer.contains(e.getEntity())) {
                e.setCancelled(true);
            }
        } else if (e.getDamager() instanceof Player) {
            if (!Main.allowedPlayer.contains(e.getDamager())) {
                e.setCancelled(true);
            }
        }
        if (e.getDamager() instanceof Projectile) {
            if (e.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) e.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    if (!Main.allowedPlayer.contains(arrow.getShooter())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
        if (e.getDamager() instanceof Trident) {
            Trident trident = (Trident) e.getDamager();
            if (trident.getShooter() instanceof Player) {
                if (!Main.allowedPlayer.contains(trident.getShooter())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    // PlayerInteractEntity
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Boat || e.getRightClicked() instanceof Minecart || e.getRightClicked() instanceof ItemFrame) {
            if (!Main.allowedPlayer.contains(e.getPlayer())) {
                e.setCancelled(true);
            }
        }
    }

    // PlayerInteractAtEntity
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if (!Main.allowedPlayer.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

    // PlayerInteract
    @Deprecated
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.PHYSICAL) {
            if (!Main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
            }
        }
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (p.getItemInHand().getType() == Material.ACACIA_BOAT
                || p.getItemInHand().getType() == Material.BIRCH_BOAT || p.getItemInHand().getType() == Material.DARK_OAK_BOAT
                || p.getItemInHand().getType() == Material.JUNGLE_BOAT || p.getItemInHand().getType() == Material.OAK_BOAT
                || p.getItemInHand().getType() == Material.SPRUCE_BOAT || p.getItemInHand().getType() == Material.MINECART
                || p.getItemInHand().getType() == Material.CHEST_MINECART || p.getItemInHand().getType() == Material.FURNACE_MINECART
                || p.getItemInHand().getType() == Material.HOPPER_MINECART || p.getItemInHand().getType() == Material.TNT_MINECART
                || p.getItemInHand().getType() == Material.ARMOR_STAND || p.getItemInHand().getType() == Material.BONE_MEAL)) {
            if (!Main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
            }
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType().equals(Material.DRAGON_EGG)) {
            if (!Main.allowedPlayer.contains(p)) {
                e.setCancelled(true);
            }
        }
    }

    // VehicleBlockCollision
    @EventHandler
    public void onVehicleBlockCollision(VehicleDestroyEvent e) {
        if (e.getVehicle() instanceof Boat || e.getVehicle() instanceof Minecart) {
            if (!Main.allowedPlayer.contains(e.getAttacker())) {
                e.setCancelled(true);
            }
        }
    }

    // PlayerShearEntity
    @EventHandler
    public void onPlayerShearEntity(PlayerShearEntityEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

    // HangingBreakByEntity
    @EventHandler
    public void onItemFrameBreak(HangingBreakByEntityEvent e) {
        if (e.getRemover() instanceof Player) {
            if (!Main.allowedPlayer.contains(e.getRemover())) {
                e.setCancelled(true);
            }
        }
        if (e.getRemover() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getRemover();
            if (arrow.getShooter() instanceof Player) {
                if (!Main.allowedPlayer.contains(arrow.getShooter())) {
                    e.setCancelled(true);
                }
            }
        } else if (e.getRemover() instanceof Trident) {
            Trident trident = (Trident) e.getRemover();
            if (trident.getShooter() instanceof Player) {
                if (!Main.allowedPlayer.contains(trident.getShooter())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    // HangingPlace
    @EventHandler
    public void onEntityPlace(HangingPlaceEvent e) {
        if (e.getEntity() instanceof ItemFrame) {
            if (!Main.allowedPlayer.contains(e.getPlayer())) {
                e.setCancelled(true);
            }
        }
    }

    // PlayerBedEntry
    @EventHandler
    public void onPlayerBedEntry(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        boolean permexo = PermissionsEx.getUser(p).inGroup("Owner");
        boolean permexv = PermissionsEx.getUser(p).inGroup("Vice");
        boolean permexf = PermissionsEx.getUser(p).inGroup("Fellow");
        long time = Bukkit.getServer().getWorld("world").getTime();
        boolean storm = Bukkit.getServer().getWorld("world").hasStorm();
        List<Entity> nearby = p.getNearbyEntities(8, 5, 0);
        if (time >= 12542 && time <= 23459 || storm) {
            if (nearby != null) {
                Bukkit.broadcastMessage("True");
                if (permexo) {
                    Bukkit.broadcastMessage("§4§l" + p.getName() + " §fist schlafen gegangen.");
                } else if (permexv) {
                    Bukkit.broadcastMessage("§c" + p.getName() + " §fist schlafen gegangen.");
                } else if (permexf) {
                    Bukkit.broadcastMessage("§5" + p.getName() + " §fist schlafen gegangen.");
                }
            } else {
                Bukkit.broadcastMessage("Else");
            }
        }
    }

    // PlayerBedLeave
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent e) {
        Player p = e.getPlayer();
        boolean permexo = PermissionsEx.getUser(p).inGroup("Owner");
        boolean permexv = PermissionsEx.getUser(p).inGroup("Vice");
        boolean permexf = PermissionsEx.getUser(p).inGroup("Fellow");
        long time = Bukkit.getServer().getWorld("world").getTime();
        boolean storm = Bukkit.getServer().getWorld("world").hasStorm();
        if (time >= 12542 && time <= 23459 || storm) {
            if (permexo) {
                Bukkit.broadcastMessage("§4§l" + p.getName() + " §fist wieder aufgestanden.");
            } else if (permexv) {
                Bukkit.broadcastMessage("§c" + p.getName() + " §fist wieder aufgestanden.");
            } else if (permexf) {
                Bukkit.broadcastMessage("§5" + p.getName() + " §fist wieder aufgestanden.");
            }
        }
    }

    // PlayerPortal
    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

    // BlockIgnite
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

    // PlayerBucketEmpty
    @EventHandler
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

    // PlayerBucketFill
    @EventHandler
    public void onPlayerBucketFill(PlayerBucketFillEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

    // PlayerEditBook
    @EventHandler
    public void onPlayerEditBook(PlayerEditBookEvent e) {
        Player p = e.getPlayer();
        if (!Main.allowedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }
}