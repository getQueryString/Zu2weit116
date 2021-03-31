// Copyright© by Fin

package Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import static Main.Main.lore;

public class Recipe {

    public static void Recipe() {
        lore.add("");
        lore.add("Das heilige Schwert von König KingKong");
        lore.add("§4§lMächtiger als Notch");
        lore.add("");
        lore.add("§cBevor Minecraft exetierte,");
        lore.add("§cwurde das Schwert schon von dem König angefangen");
        lore.add("§czu schmieden. Doch nach der Reparatur wurde das");
        lore.add("§cSchwert §c§lunzersörbar§c.");
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Schwert von König KingKong");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 25, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, -1, true);
        meta.addEnchant(Enchantment.LUCK, -1, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, true);
        meta.addEnchant(Enchantment.THORNS, -2, true);
        meta.addEnchant(Enchantment.DIG_SPEED, -1, true);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, -1, true);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "abcabc");
        ShapedRecipe rc = new ShapedRecipe(key, item);
        rc.shape(new String[]{"DPL", "NEN", "LSB"});
        rc.setIngredient('E', Material.DRAGON_EGG);
        rc.setIngredient('S', Material.STICK);
        rc.setIngredient('B', Material.BLAZE_ROD);
        rc.setIngredient('N', Material.NETHER_STAR);
        rc.setIngredient('D', Material.DIAMOND);
        rc.setIngredient('P', Material.BLAZE_POWDER);
        Bukkit.addRecipe(rc);
    }

}