// Copyright© by Fin

package Listeners;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class EpicScoreboard {
    public Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

    public EpicScoreboard(Player p) {
        Team Operator = this.sb.registerNewTeam("001op");
        Team Owner = this.sb.registerNewTeam("002owner");
        Team Vice = this.sb.registerNewTeam("003vice");
        Team Fellow = this.sb.registerNewTeam("004fellow");
        Team Spieler = this.sb.registerNewTeam("005spieler");
        Owner.setPrefix("§4§lOwner | ");
        Operator.setPrefix("§0§lOperator | ");
        Vice.setPrefix("§cVice | ");
        Fellow.setPrefix("§5Fellow | ");
        Spieler.setPrefix("§8Spieler | ");
    }

    public void sendToPlayer(Player p) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (PermissionsEx.getUser(p).inGroup("Owner")) {
                this.sb.getTeam("002owner").addEntry(player.getName());
                continue;
            }
            if (player.isOp()) {
                this.sb.getTeam("001op").addEntry(player.getName());
                continue;
            }
            if (PermissionsEx.getUser(p).inGroup("Vice")) {
                this.sb.getTeam("003vice").addEntry(player.getName());
                continue;
            }
            if (PermissionsEx.getUser(p).inGroup("Fellow")) {
                this.sb.getTeam("004fellow").addEntry(player.getName());
                continue;
            }
            this.sb.getTeam("005spieler").addEntry(player.getName());
        }
        p.setScoreboard(this.sb);
        main.scoreboard.put(p.getUniqueId(), this);
    }
}
