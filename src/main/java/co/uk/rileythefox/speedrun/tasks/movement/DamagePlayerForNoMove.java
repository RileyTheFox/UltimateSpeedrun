package co.uk.rileythefox.speedrun.tasks.movement;

import co.uk.rileythefox.speedrun.SpeedrunCore;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class DamagePlayerForNoMove implements Runnable {

    public BukkitTask task;
    private Player player;

    public DamagePlayerForNoMove(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        if (player.getHealth() - 0.5 >= 0.5) {
            player.setHealth(player.getHealth() - 0.5);
        } else {
            player.setHealth(0);
            SpeedrunCore.getInstance().playersWhoMoved.remove(player);
            task.cancel();
        }
    }
}
