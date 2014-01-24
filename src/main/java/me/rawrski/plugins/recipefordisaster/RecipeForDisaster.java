package me.rawrski.plugins.recipefordisaster;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeForDisaster extends JavaPlugin implements Listener {

    /**
     * Register the events for our plugin
     */
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        addRecipes();
    }

    /**
     * Adds recipes to the server recipe list
     */
    public void addRecipes() {
        //Cobblestone + Vine = Mossy Cobblestone
        ShapelessRecipe cobbleToMossy = new ShapelessRecipe(new ItemStack(Material.MOSSY_COBBLESTONE));
        cobbleToMossy.addIngredient(Material.COBBLESTONE);
        cobbleToMossy.addIngredient(Material.VINE);
        getServer().addRecipe(cobbleToMossy);
    }

    /**
     * Update the Players Inventory after one tick every successful craft to workaround a Bukkit Bug
     */
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        final Player player = (Player) event.getWhoClicked();
        player.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                player.updateInventory();
            }
        }, 1);
    }

}

