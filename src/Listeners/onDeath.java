// Copyright© by Fin

package Listeners;

import Main.Main;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.projectiles.BlockProjectileSource;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class onDeath implements Listener {

    static String playerColor = null;
    static String killerColor = null;

    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();

        PermissionUser permexPlayer = PermissionsEx.getUser(p);

        if (permexPlayer.inGroup("Owner")) playerColor = "§4§l";
        else if (permexPlayer.inGroup("Vice")) playerColor = "§c";
        else if (permexPlayer.inGroup("Fellow")) playerColor = "§5";
        else if (permexPlayer.inGroup("default")) playerColor = "§8";

        // Player deaths
        if (p instanceof Player) {
            EntityDamageEvent gldc = p.getLastDamageCause();
            if (p.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §ffiel aus zu großer Höhe.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.LAVA) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fversuchte in Lava zu schwimmen.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.DROWNING) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fertrank.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.DRYOUT) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fDRYOUT.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.CRAMMING) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fCRAMMING.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.CONTACT) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §CONTACT.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.CUSTOM) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fCUSTOM.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.DRAGON_BREATH) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fDRAGON_BREATH.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fENTITY_ATTACK.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fENTITY_SWEEP_ATTACK.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.FIRE) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fging in Flammen auf.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fverbrannte.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fFLY_INTO_WALL.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fHOT_FLOOR.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fLIGHTNING.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.MAGIC) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fMAGIC.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.MELTING) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fMELTING.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.POISON) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fPOITSON.");
                }
            } /*else if (gldc.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            } */ else if (gldc.getCause() == EntityDamageEvent.DamageCause.STARVATION) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fverhungerte.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde lebendig begraben.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.SUICIDE) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fSUICIDE.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.THORNS) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fTHORNS.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.VOID) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §ffiel aus der Welt.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.WITHER) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fWITHER.");
                }
            } else if (k == p) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fsuizidierte sich.");
                }
            }
        }

        // Player deaths from mobs etc
        if (e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent lastDamageCause = (EntityDamageByEntityEvent) e.getEntity().getLastDamageCause();
            Entity killer = lastDamageCause.getDamager();
            String getItem = killer.getName();
            if (killer instanceof Entity && !(killer instanceof Creeper) && !(killer instanceof Arrow) && !(killer instanceof Trident)
                    && !(killer instanceof Bee) && !(killer instanceof TNTPrimed) && !(killer instanceof FallingBlock) && !(p == k) && !(k != null)) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von §e" + killer.getName() + " §ferschlagen.");
                }
            } else if (killer instanceof Creeper) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von §e" + killer.getName() + " §fin die Luft gesprengt.");
                }
            } else if (killer instanceof Arrow) {
                Arrow arrow = (Arrow) lastDamageCause.getDamager();
                if (arrow.getShooter() instanceof BlockProjectileSource) {

                    if (playerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von §e" + getItem + " §ferschossen.");
                    }
                } else if (!(arrow.getShooter() instanceof BlockProjectileSource) && !(p == k) && !(k != null)) {
                    String shooter = ((Entity) arrow.getShooter()).getName();

                    if (playerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von §e" + shooter + " §ferschossen.");
                    }
                } else if (p == k) {

                    if (playerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    }
                } else if (k != null) {

                    if (playerColor != null && killerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von " + killerColor + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    }
                }
            } else if (killer instanceof Trident) {
                Trident trident = (Trident) lastDamageCause.getDamager();
                String shooter = ((Entity) trident.getShooter()).getName();
                if (k instanceof Player) {

                    PermissionUser permexKiller = PermissionsEx.getUser(k);
                    if (permexKiller.inGroup("Owner")) killerColor = "§4§l";
                    else if (permexKiller.inGroup("Vice")) killerColor = "§c";
                    else if (permexKiller.inGroup("Fellow")) killerColor = "§5";
                    else if (permexKiller.inGroup("default")) killerColor = "§8";
                    if (playerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von " + killerColor + shooter + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    }
                } else if (p == k) {

                    if (playerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    }
                } else {
                    if (playerColor != null) {
                        e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von §e" + shooter + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    }
                }
            } else if (killer instanceof Bee) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von §e" + killer.getName() + " §fzu Tode erstochen.");
                }
            } else if (killer instanceof FallingBlock) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde durch §e" + killer.getName() + " §fzerquetscht.");
                }
            } else if (p == k) {

                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                }
            } else if (k != null) {

                PermissionUser permexKiller = PermissionsEx.getUser(k);
                if (permexKiller.inGroup("Owner")) killerColor = "§4§l";
                else if (permexKiller.inGroup("Vice")) killerColor = "§c";
                else if (permexKiller.inGroup("Fellow")) killerColor = "§5";
                else if (permexKiller.inGroup("default")) killerColor = "§8";
                if (playerColor != null) {
                    e.setDeathMessage(Main.pre + " " + playerColor + p.getName() + " §fwurde von " + killerColor + k.getName() + " §fgetötet.");
                }
            }
        }
    }
}