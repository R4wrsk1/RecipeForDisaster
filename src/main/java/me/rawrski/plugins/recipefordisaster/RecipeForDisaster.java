package me.rawrski.plugins.recipefordisaster;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeForDisaster extends JavaPlugin implements Listener {

    /**
     * Register the events for our plugin
     */
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    /**
     * Adds recipes to the server recipe list
     */
    public void addRecipes() {
        //Cobblestone + Vine = Mossy Cobblestone
        ShapelessRecipe cobbleToMossy = new ShapelessRecipe(new ItemStack(Material.MOSSY_COBBLESTONE))
                .addIngredient(1, Material.COBBLESTONE).addIngredient(1, Material.VINE);
        getServer().addRecipe(cobbleToMossy);
    }

}

