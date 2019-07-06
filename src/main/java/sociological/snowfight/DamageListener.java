package sociological.snowfight;

import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE && event.getDamager() instanceof Snowball) {
            event.setDamage(2);
            String name = event.getDamager().getCustomName();
            if (name != null) {
                if (name.equals("번개치는 눈덩이")) {
                    event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
                } else if (name.equals("강제점프 눈덩이")) {
                    event.getEntity().teleport(event.getEntity().getLocation().add(0, 4, 0));
                }
            }
        }
    }
}
