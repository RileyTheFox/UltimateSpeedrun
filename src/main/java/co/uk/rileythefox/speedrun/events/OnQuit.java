package co.uk.rileythefox.speedrun.events;

import co.uk.rileythefox.speedrun.SpeedrunCore;
import co.uk.rileythefox.speedrun.tasks.movement.CheckNoMovement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (CheckNoMovement.tasks.containsKey(event.getPlayer())) {
            CheckNoMovement.tasks.get(event.getPlayer()).cancel();
            CheckNoMovement.tasks.remove(event.getPlayer());
        }
        SpeedrunCore.getInstance().playersWhoMoved.remove(event.getPlayer());
    }

}
