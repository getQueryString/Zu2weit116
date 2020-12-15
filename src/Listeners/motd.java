// Copyright© by Fin

package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class motd implements Listener {
    @EventHandler
    public void onMotd(ServerListPingEvent e) {
        e.setMotd(
                "§b§lZu2weit §f§l- §4Das Geheimnis eines heiligen Schwertes\n            §8§ §fEin Projekt von Fin & Roman §8§");
        e.setMaxPlayers(2);
    }
}