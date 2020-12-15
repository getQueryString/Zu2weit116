// Copyright© by Fin

package Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Whitelist_PlayerLogin implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST)
            e.setKickMessage(
                    "§7- * - + - * - §8[§b§lZu2weit§8] §7 - * - + - * -\n\n§7Die §aWhitelist §7ist aktiviert.\n§7Bitte versuchen Sie es §cnicht §7erneut!\n§4§lDanke für Ihr Verständnis!");
    }
}