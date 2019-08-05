package sociological.snowfight;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public final class Snowfight extends JavaPlugin {
    private static void removeCraftRecipe() {
        remove(Material.COOKED_BEEF);
    }

    private static void remove(Material m) {
        Iterator<Recipe> IR = Bukkit.getServer().recipeIterator();
        Recipe R;
        while (IR.hasNext()) {
            R = IR.next();
            if (R != null && R.getResult().getType() == m) {
                IR.remove();
            }
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        removeCraftRecipe();
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new ProjectileListener(), this);
        pluginManager.registerEvents(new DamageListener(), this);
        pluginManager.registerEvents(new UseItemListener(), this);
        pluginManager.registerEvents(new ProjectileHitListener(), this);
        ItemStack hotpack = new ItemStack(Material.COOKED_BEEF, 1);
        hotpack.getItemMeta().setDisplayName(ChatColor.RESET + "재활용 핫팩");
        getServer().addRecipe(new FurnaceRecipe(new NamespacedKey(this, "sociological"), hotpack, Material.BEEF, 0, 200));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
