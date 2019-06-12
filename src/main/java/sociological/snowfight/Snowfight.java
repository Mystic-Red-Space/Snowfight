package sociological.snowfight;

import org.bukkit.plugin.java.JavaPlugin;

public final class Snowfight extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new SnowballListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logicd
    }
}
