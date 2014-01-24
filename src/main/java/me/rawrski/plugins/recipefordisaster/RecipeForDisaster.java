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
        mossyCobbleRecipe();
        chiseledStoneBrickRecipe();
    }

    public void mossyCobbleRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.MOSSY_COBBLESTONE)); //Block the shapeless recipe turns into
        recipe.addIngredient(Material.COBBLESTONE); //Ingredient #1
        recipe.addIngredient(Material.VINE); //Ingredient #2
        getServer().addRecipe(recipe); // Adds recipe to server
    }

    public void chiseledStoneBrickRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.SMOOTH_BRICK, 1, (short) 3));
        recipe.addIngredient(Material.STEP, 5);
        recipe.addIngredient(Material.STEP, 5);
        getServer().addRecipe(recipe);
    }

    /*
    public void example() {
        ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.SMOOTH_STAIRS));
        recipe.shape("saa", "ssa", "sss");
        recipe.setIngredient('a', Material.AIR);
        recipe.setIngredient('s', Material.SMOOTH_BRICK);
        getServer().addRecipe(recipe);
    }
    */

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

