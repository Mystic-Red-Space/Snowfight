package sociological.snowfight;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.Objects;


public class SnowballListener implements Listener {
    @EventHandler
    public void onSnowballThrowed(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Snowball && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            String name = Objects.requireNonNull(shooter.getInventory().getItemInMainHand().getItemMeta()).getDisplayName();
            event.getEntity().setCustomName(name);
        }
    }
}
