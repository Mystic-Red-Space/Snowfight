package sociological.snowfight;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Random;

public class ProjectileHitListener implements Listener {
    private Random rand = new Random();

    @EventHandler
    public void OnProjectileHited(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {
            if (event.getEntity().getCustomName().equals("전도성 눈덩이")) {
                Location loc = event.getEntity().getLocation();
                event.getEntity().getWorld().strikeLightning(loc);
            } else if (event.getEntity().getCustomName().equals("강제점프 눈덩이") && event.getHitEntity() != null) {
                event.getHitEntity().teleport(event.getEntity().getLocation().add(0, 4, 0));
            } else if (event.getEntity().getCustomName().equals("랜덤이동 눈덩이") && event.getHitEntity() != null) {
                event.getHitEntity().teleport(event.getEntity().getLocation().add(rand.nextInt(11) - 5, 0, rand.nextInt(11) - 5));
            } else if (event.getEntity().getCustomName().equals("위치교환 눈덩이"))
                if (event.getHitEntity() != null) {
                    Location shooterloc = ((Entity) event.getEntity().getShooter()).getLocation();
                    Location hitterloc = event.getHitEntity().getLocation();
                    ((Entity) event.getEntity().getShooter()).teleport(hitterloc);
                    event.getHitEntity().teleport(shooterloc);
                } else if (event.getHitBlock() != null) {
                    Location loc = event.getHitBlock().getLocation();
                    ((Entity) event.getEntity().getShooter()).teleport(new Location(((Entity) event.getEntity().getShooter()).getWorld(), loc.getX(), loc.getY() + 1, loc.getZ(), ((Entity) event.getEntity().getShooter()).getLocation().getYaw(), ((Entity) event.getEntity().getShooter()).getLocation().getPitch()));
                }
        }
    }
}
