package sociological.snowfight;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import java.util.Random;

public class ProjectileHitListener implements Listener {
    private Random rand = new Random();

    @EventHandler
    public void OnProjectileHited(ProjectileHitEvent event) {
        Projectile entity = event.getEntity();
        if (entity instanceof Snowball && entity.getCustomName() != null) {
            if (entity.getCustomName().equals("전도성 눈덩이")) {
                Location loc = entity.getLocation();
                entity.getWorld().strikeLightning(loc);
            } else if (entity.getCustomName().equals("강제점프 눈덩이") && event.getHitEntity() != null) {
                event.getHitEntity().setVelocity(new Vector(0, 1, 0));
                /*event.getHitEntity().teleport(entity.getLocation().add(0, 4, 0));*/
            } else if (entity.getCustomName().equals("랜덤이동 눈덩이") && event.getHitEntity() != null) {
                Entity HitEntity = event.getHitEntity();
                event.getHitEntity().teleport(new Location(HitEntity.getWorld(), HitEntity.getLocation().getX() + (rand.nextInt(11) - 5), HitEntity.getLocation().getY(), HitEntity.getLocation().getZ() + (rand.nextInt(11) - 5), HitEntity.getLocation().getYaw(), HitEntity.getLocation().getPitch()));
                /*event.getHitEntity().teleport(entity.getLocation().add(rand.nextInt(11) - 5, 0, rand.nextInt(11) - 5));*/
            } else if (entity.getCustomName().equals("위치교환 눈덩이"))
                if (event.getHitEntity() != null && entity.getShooter() != null) {
                    Location shooterloc = ((Entity) entity.getShooter()).getLocation();
                    Location hitterloc = event.getHitEntity().getLocation();
                    ((Entity) entity.getShooter()).teleport(new Location(entity.getWorld(), hitterloc.getX(), hitterloc.getY(), hitterloc.getZ(), shooterloc.getYaw(), shooterloc.getPitch()));
                    event.getHitEntity().teleport(new Location(entity.getWorld(), shooterloc.getX(), shooterloc.getY(), shooterloc.getZ(), hitterloc.getYaw(), hitterloc.getPitch()));
                } else if (event.getHitBlock() != null && entity.getShooter() != null) {
                    Location loc = event.getHitBlock().getLocation();
                    ((Entity) entity.getShooter()).teleport(new Location(((Entity) entity.getShooter()).getWorld(), loc.getX(), loc.getY() + 1, loc.getZ(), ((Entity) entity.getShooter()).getLocation().getYaw(), ((Entity) entity.getShooter()).getLocation().getPitch()));
                }
        }
    }
}
