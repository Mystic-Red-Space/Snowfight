package sociological.snowfight;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class UseItemListener implements Listener {
    @EventHandler
    public void onItemUsed(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getType() == Material.FIRE_CHARGE) {
                    SmallFireball fireball = player.getWorld().spawn(player.getLocation(), SmallFireball.class);
                    fireball.setShooter(player);
                    event.useItemInHand();
                } else if (event.getItem().getType() == Material.COOKED_BEEF && event.getItem().getItemMeta().hasDisplayName()) {
                    if (event.getItem().getItemMeta().getDisplayName().equals("새 핫팩")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 3, true, true), true);
                        ItemStack remove = new ItemStack(Material.COOKED_BEEF, 1);
                        ItemMeta removemeta = remove.getItemMeta();
                        removemeta.setDisplayName("새 핫팩");
                        remove.setItemMeta(removemeta);
                        player.getInventory().remove(remove);
                        ItemStack hotpack = new ItemStack(Material.BEEF, 1);
                        ItemMeta hotpackmeta = hotpack.getItemMeta();
                        hotpackmeta.setDisplayName(ChatColor.RESET + "차가운 핫팩");
                        hotpack.setItemMeta(hotpackmeta);
                        player.getInventory().addItem(hotpack);
                    } else if (event.getItem().getItemMeta().getDisplayName().equals("재활용 핫팩")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 2, true, true), true);
                        ItemStack remove = new ItemStack(Material.COOKED_BEEF, 1);
                        ItemMeta removemeta = remove.getItemMeta();
                        removemeta.setDisplayName("재활용 핫팩");
                        remove.setItemMeta(removemeta);
                    }
                }
            }
        }
    }
}
