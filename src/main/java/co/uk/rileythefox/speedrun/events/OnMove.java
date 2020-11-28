package co.uk.rileythefox.speedrun.events;

import co.uk.rileythefox.speedrun.SpeedrunCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!SpeedrunCore.getInstance().playersWhoMoved.containsKey(event.getPlayer())) {
            if (event.getFrom().getBlockX() != event.getTo().getBlockX()
                    || event.getFrom().getBlockZ() != event.getTo().getBlockZ()
                    || event.getFrom().getBlockY() != event.getTo().getBlockY()) {
                SpeedrunCore.getInstance().playersWhoMoved.put(event.getPlayer(), System.currentTimeMillis());
            }
        } else {
            if (event.getFrom().getX() != event.getTo().getX()
                    || event.getFrom().getZ() != event.getTo().getZ()
                    || event.getFrom().getY() != event.getTo().getY()) {
                SpeedrunCore.getInstance().playersWhoMoved.put(event.getPlayer(), System.currentTimeMillis());
            }
        }

    }

}
