package sociological.snowfight;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FireballListener implements Listener {
    @EventHandler
    public void onFireballClicked(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null && event.getItem().getType() == Material.FIRE_CHARGE) {
            SmallFireball fireball = player.getWorld().spawn(player.getLocation(), SmallFireball.class);
            fireball.setShooter(player);
            player.getInventory().removeItem(new ItemStack(Material.FIRE_CHARGE, 1));
        }
    }
}
