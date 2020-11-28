package co.uk.rileythefox.speedrun.tasks.movement;

import co.uk.rileythefox.speedrun.SpeedrunCore;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class CheckNoMovement implements Runnable {

    public static Map<Player, BukkitTask> tasks = new HashMap<>();

    @Override
    public void run() {
        for (Player player : SpeedrunCore.getInstance().playersWhoMoved.keySet()) {
            if (System.currentTimeMillis() - SpeedrunCore.getInstance().playersWhoMoved.get(player) > 1000) {
                if (player.getHealth() - 0.5 >= 0.5) {
                    player.setHealth(player.getHealth() - 0.5);
                } else {
                    player.setHealth(0);
                    SpeedrunCore.getInstance().playersWhoMoved.remove(player);
                }
            }
/*
            if (cachedLoc.getBlockX() == player.getLocation().getBlockX() && cachedLoc.getBlockZ() == player.getLocation().getBlockZ()) {
                if (tasks.containsKey(player))
                    continue;

                DamagePlayerForNoMove obj = new DamagePlayerForNoMove(player);

                BukkitTask task = Bukkit.getScheduler().runTaskTimer(SpeedrunCore.getInstance(), obj, 0, 5);
                obj.task = task;
                tasks.put(player, task);
            } else {
                if (tasks.containsKey(player)) {
                    tasks.get(player).cancel();
                    tasks.remove(player);
                }
            }
            lastLocations.put(player, player.getLocation());*/
        }
    }
}
