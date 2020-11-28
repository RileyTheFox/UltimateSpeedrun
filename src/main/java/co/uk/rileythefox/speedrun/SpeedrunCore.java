package co.uk.rileythefox.speedrun;

import co.uk.rileythefox.speedrun.events.OnMove;
import co.uk.rileythefox.speedrun.events.OnQuit;
import co.uk.rileythefox.speedrun.tasks.movement.CheckNoMovement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SpeedrunCore extends JavaPlugin {

    public Map<Player, Long> playersWhoMoved = new HashMap<>();

    private static SpeedrunCore instance;

    public static SpeedrunCore getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyHeader(true);

        if (!new File(getDataFolder(), "config.yml").exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
            reloadConfig();
        }

        getServer().getPluginManager().registerEvents(new OnMove(), this);
        getServer().getPluginManager().registerEvents(new OnQuit(), this);

        if (getConfig().getBoolean(Setting.DAMAGE_ON_NO_MOVEMENT.getPath())) {
            Bukkit.getLogger().info("lol");
            getServer().getScheduler().runTaskTimer(this, new CheckNoMovement(), 0, 5);
        }
    }

    @Override
    public void onDisable() {

    }

}
