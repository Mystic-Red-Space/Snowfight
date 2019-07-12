package sociological.snowfight;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            if (event.getDamager() instanceof Snowball) {
                if (Objects.requireNonNull(event.getEntity().getCustomName()).equals("눈덩이")) {
                    event.setDamage(2);
                } else {
                    event.setCancelled(true);
                }
            } else if (event.getDamager() instanceof Trident) {
                event.setDamage(2);
                ((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 255, false, false, false),true);
                ((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60, 128, false, false, false),true);
                ((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 255, false, false, false),true);
            }
        }
    }
}
