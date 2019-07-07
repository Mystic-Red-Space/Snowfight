package sociological.snowfight;

import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            if (event.getDamager() instanceof Snowball) {
                if (event.getDamager() instanceof Snowball && event.getEntity().getCustomName().equals("눈덩이")) {
                    event.setDamage(2);
                } else if (event.getDamager() instanceof Snowball && !event.getEntity().getCustomName().equals("눈덩이")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
