package sociological.snowfight;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;


public class SnowballListener implements Listener {
    @EventHandler
    public void onSnowballThrowed(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Snowball && event.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) event.getEntity().getShooter();
            String name = (((Player) event.getEntity().getShooter()).getInventory().getItemInMainHand().getItemMeta().getDisplayName());
            if (shooter.getInventory().contains(Material.SNOW_BLOCK)) {
                shooter.getInventory().removeItem(new ItemStack(Material.SNOW_BLOCK, 1));
            } else {
                shooter.setCooldown(Material.SNOWBALL, 60);
            }
            event.getEntity().setCustomName(name);
        }
    }
}
