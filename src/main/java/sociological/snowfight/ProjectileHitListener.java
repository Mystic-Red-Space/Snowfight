package sociological.snowfight;

import org.bukkit.Location;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitListener implements Listener {
    @EventHandler
    public void OnProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball && event.getEntity().getCustomName().equals("전도성 눈덩이")) {
            Location loc = event.getEntity().getLocation();
            event.getEntity().getWorld().strikeLightning(loc);
        } else if (event.getEntity() instanceof Snowball && event.getEntity().getCustomName().equals("강제점프 눈덩이") && event.getHitEntity() != null) {
            event.getHitEntity().teleport(event.getEntity().getLocation().add(0, 4, 0));
        }
    }
}
