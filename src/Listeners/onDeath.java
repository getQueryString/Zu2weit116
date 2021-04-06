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
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class onDeath implements Listener {

    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        boolean permexo = PermissionsEx.getUser(p).inGroup("Owner");
        boolean permexv = PermissionsEx.getUser(p).inGroup("Vice");
        boolean permexf = PermissionsEx.getUser(p).inGroup("Fellow");
        boolean permexd = PermissionsEx.getUser(p).inGroup("default");

        // Player deaths
        if (p instanceof Player) {
            EntityDamageEvent gldc = p.getLastDamageCause();
            if (p.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §ffiel aus zu großer Höhe.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §ffiel aus zu großer Höhe.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §ffiel aus zu großer Höhe.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §ffiel aus zu großer Höhe.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.LAVA) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fversuchte in Lava zu schwimmen.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fversuchte in Lava zu schwimmen.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fversuchte in Lava zu schwimmen.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fversuchte in Lava zu schwimmen.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fertrank.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fertrank.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fertrank.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fertrank.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.DRYOUT) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fDRYOUT.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fDRYOUT.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fDRYOUT.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fDRYOUT.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.CRAMMING) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fCRAMMING.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fCRAMMING.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fCRAMMING.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fCRAMMING.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §CONTACT.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §CONTACT.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §CONTACT.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §CONTACT.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.CUSTOM) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fCUSTOM.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fCUSTOM.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fCUSTOM.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fCUSTOM.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.DRAGON_BREATH) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fDRAGON_BREATH.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fDRAGON_BREATH.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fDRAGON_BREATH.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fDRAGON_BREATH.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fENTITY_ATTACK.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fENTITY_ATTACK.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fENTITY_ATTACK.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fENTITY_ATTACK.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fENTITY_SWEEP_ATTACK.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fENTITY_SWEEP_ATTACK.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fENTITY_SWEEP_ATTACK.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fENTITY_SWEEP_ATTACK.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.FIRE) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fging in Flammen auf.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fging in Flammen auf.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fging in Flammen auf.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fging in Flammen auf.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fverbrannte.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fverbrannte.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fverbrannte.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fverbrannte.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fFLY_INTO_WALL.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fFLY_INTO_WALL.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fFLY_INTO_WALL.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fFLY_INTO_WALL.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fHOT_FLOOR.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fHOT_FLOOR.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fHOT_FLOOR.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fHOT_FLOOR.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fLIGHTNING.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fLIGHTNING.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fLIGHTNING.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fLIGHTNING.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.MAGIC) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fMAGIC.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fMAGIC.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fMAGIC.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fMAGIC.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.MELTING) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fMELTING.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fMELTING.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fMELTING.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fMELTING.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.POISON) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fPOITSON.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fPOITSON.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fPOITSON.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fPOITSON.");
                }
            } /*else if (gldc.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            } */ else if (gldc.getCause() == EntityDamageEvent.DamageCause.STARVATION) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fverhungerte.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fverhungerte.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fverhungerte.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fverhungerte.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde lebendig begraben.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde lebendig begraben.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde lebendig begraben.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde lebendig begraben.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.SUICIDE) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fSUICIDE.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fSUICIDE.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fSUICIDE.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fSUICIDE.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.THORNS) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fTHORNS.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fTHORNS.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fTHORNS.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fTHORNS.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.VOID) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §ffiel aus der Welt.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §ffiel aus der Welt.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §ffiel aus der Welt.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §ffiel aus der Welt.");
                }
            } else if (gldc.getCause() == EntityDamageEvent.DamageCause.WITHER) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fWITHER.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fWITHER.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fWITHER.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fWITHER.");
                }
            }
            if (k != null && !(k == p)) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + k.getName() + " §fgetötet.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + k.getName() + " §fgetötet.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + k.getName() + " §fgetötet.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + k.getName() + " §fgetötet.");
                }
            } else if (k == p) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fsuizidierte sich.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fsuizidierte sich.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fsuizidierte sich.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fsuizidierte sich.");
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
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + killer.getName() + " §ferschlagen.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §e" + killer.getName() + " §ferschlagen.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §e" + killer.getName() + " §ferschlagen.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §e" + killer.getName() + " §ferschlagen.");
                }
            } else if (killer instanceof Creeper) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + killer.getName() + " §fin die Luft gesprengt.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §e" + killer.getName() + " §fin die Luft gesprengt.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §e" + killer.getName() + " §fin die Luft gesprengt.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §e" + killer.getName() + " §fin die Luft gesprengt.");
                }
            } else if (killer instanceof Arrow) {
                Arrow arrow = (Arrow) lastDamageCause.getDamager();
                if (arrow.getShooter() instanceof BlockProjectileSource) {
                    if (permexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + getItem + " §ferschossen.");
                    } else if (permexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §e" + getItem + " §ferschossen.");
                    } else if (permexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §e" + getItem + " §ferschossen.");
                    } else if (permexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §e" + getItem + " §ferschossen.");
                    }
                } else if (!(arrow.getShooter() instanceof BlockProjectileSource) && !(p == k) && !(k != null)) {
                    String shooter = ((Entity) arrow.getShooter()).getName();
                    if (permexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + shooter + " §ferschossen.");
                    } else if (permexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §e" + shooter + " §ferschossen.");
                    } else if (permexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §e" + shooter + " §ferschossen.");
                    } else if (permexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §e" + shooter + " §ferschossen.");
                    }
                } else if (p == k) {
                    if (permexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    }
                } else if (k != null) {
                    boolean kpermexo = PermissionsEx.getUser(k).inGroup("Owner");
                    boolean kpermexv = PermissionsEx.getUser(k).inGroup("Vice");
                    boolean kpermexf = PermissionsEx.getUser(k).inGroup("Fellow");
                    boolean kpermexd = PermissionsEx.getUser(k).inGroup("default");
                    if (permexo && kpermexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexo && kpermexv) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexo && kpermexf) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexo && kpermexd) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexv && kpermexo) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexv && kpermexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexv && kpermexf) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexv && kpermexd) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexf && kpermexo) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexf && kpermexv) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexf && kpermexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexf && kpermexd) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexd && kpermexo) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexd && kpermexv) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexd && kpermexf) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    } else if (permexd && kpermexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + getItem + " §ferschossen.");
                    }
                }
            } else if (killer instanceof Trident) {
                Trident trident = (Trident) lastDamageCause.getDamager();
                String shooter = ((Entity) trident.getShooter()).getName();
                if (killer instanceof Player) {
                    if (permexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + shooter + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §e" + shooter + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §e" + shooter + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §e" + shooter + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    }
                } else if (p == k) {
                    if (permexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.e ");
                    } else if (permexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                    }
                } else if (k != null) {
                    boolean kpermexo = PermissionsEx.getUser(k).inGroup("Owner");
                    boolean kpermexv = PermissionsEx.getUser(k).inGroup("Vice");
                    boolean kpermexf = PermissionsEx.getUser(k).inGroup("Fellow");
                    boolean kpermexd = PermissionsEx.getUser(k).inGroup("default");
                    if (permexo && kpermexo) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexo && kpermexv) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexo && kpermexf) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexo && kpermexd) {
                        e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv && kpermexo) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv && kpermexv) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv && kpermexf) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexv && kpermexd) {
                        e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexf && kpermexo) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexf && kpermexv) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexf && kpermexf) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexf && kpermexd) {
                        e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd && kpermexo) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd && kpermexv) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §c" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd && kpermexf) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §5" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    } else if (permexd && kpermexd) {
                        e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §8" + k.getName() + " §fmit einem §e" + killer.getName() + " §ferschossen.");
                    }
                }
            } else if (killer instanceof Bee) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §e" + killer.getName() + " §fzu Tode erstochen.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §e" + killer.getName() + " §fzu Tode erstochen.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §e" + killer.getName() + " §fzu Tode erstochen.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §e" + killer.getName() + " §fzu Tode erstochen.");
                }
            } else if (killer instanceof FallingBlock) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde durch §e" + killer.getName() + " §fzerquetscht.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde durch §e" + killer.getName() + " §fzerquetscht.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde durch §e" + killer.getName() + " §fzerquetscht.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde durch §e" + killer.getName() + " §fzerquetscht.");
                }
            } else if (p == k) {
                if (permexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                } else if (permexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                } else if (permexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                } else if (permexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fhat sich mit einem §e" + killer.getName() + " §ferschossen.");
                }
            } else if (k != null) {
                boolean kpermexo = PermissionsEx.getUser(k).inGroup("Owner");
                boolean kpermexv = PermissionsEx.getUser(k).inGroup("Vice");
                boolean kpermexf = PermissionsEx.getUser(k).inGroup("Fellow");
                boolean kpermexd = PermissionsEx.getUser(k).inGroup("default");
                if (permexo && kpermexo) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fgetötet.");
                } else if (permexo && kpermexv) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §c" + k.getName() + " §fgetötet.");
                } else if (permexo && kpermexf) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §5" + k.getName() + " §fgetötet.");
                } else if (permexo && kpermexd) {
                    e.setDeathMessage(Main.pre + " §4§l" + p.getName() + " §fwurde von §8" + k.getName() + " §fgetötet.");
                } else if (permexv && kpermexo) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fgetötet.");
                } else if (permexv && kpermexv) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §c" + k.getName() + " §fgetötet.");
                } else if (permexv && kpermexf) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §5" + k.getName() + " §fgetötet.");
                } else if (permexv && kpermexd) {
                    e.setDeathMessage(Main.pre + " §c" + p.getName() + " §fwurde von §8" + k.getName() + " §fgetötet.");
                } else if (permexf && kpermexo) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fgetötet.");
                } else if (permexf && kpermexv) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §c" + k.getName() + " §fgetötet.");
                } else if (permexf && kpermexf) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §5" + k.getName() + " §fgetötet.");
                } else if (permexf && kpermexd) {
                    e.setDeathMessage(Main.pre + " §5" + p.getName() + " §fwurde von §8" + k.getName() + " §fgetötet.");
                } else if (permexd && kpermexo) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §4§l" + k.getName() + " §fgetötet.");
                } else if (permexd && kpermexv) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §c" + k.getName() + " §fgetötet.");
                } else if (permexd && kpermexf) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §5" + k.getName() + " §fgetötet.");
                } else if (permexd && kpermexd) {
                    e.setDeathMessage(Main.pre + " §8" + p.getName() + " §fwurde von §8" + k.getName() + " §fgetötet.");
                }
            }
        }
    }
}