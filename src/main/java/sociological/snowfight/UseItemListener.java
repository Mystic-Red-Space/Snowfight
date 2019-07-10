package sociological.snowfight;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class UseItemListener implements Listener {
    @EventHandler
    public void onItemUsed(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null && event.getItem().getType() == Material.FIRE_CHARGE) {
                SmallFireball fireball = player.getWorld().spawn(player.getLocation(), SmallFireball.class);
                fireball.setShooter(player);
            }
        }
    }
}
