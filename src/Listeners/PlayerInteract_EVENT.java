// Copyright© by Fin

package Listeners;

import Main.main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract_EVENT implements Listener {
    @EventHandler
    public void Interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((p.getWorld().getName().equals("world") || p.getWorld().getName().equals("world_nether")
                || p.getWorld().getName().equals("world_the_end")) && !main.allowedPlayer.contains(p)
                && e.getAction() == Action.RIGHT_CLICK_BLOCK
                && (e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.DROPPER
                || e.getClickedBlock().getType() == Material.DISPENSER
                || e.getClickedBlock().getType() == Material.FURNACE
                || e.getClickedBlock().getType() == Material.BEACON
                || e.getClickedBlock().getType() == Material.TRAPPED_CHEST
                || e.getClickedBlock().getType() == Material.ENDER_CHEST
                || e.getClickedBlock().getType() == Material.ENCHANTING_TABLE
                || e.getClickedBlock().getType() == Material.ANVIL
                || e.getClickedBlock().getType() == Material.CHIPPED_ANVIL
                || e.getClickedBlock().getType() == Material.DAMAGED_ANVIL
                || e.getClickedBlock().getType() == Material.CRAFTING_TABLE
                || e.getClickedBlock().getType() == Material.WHITE_BED
                || e.getClickedBlock().getType() == Material.ORANGE_BED
                || e.getClickedBlock().getType() == Material.MAGENTA_BED
                || e.getClickedBlock().getType() == Material.LIGHT_BLUE_BED
                || e.getClickedBlock().getType() == Material.YELLOW_BED
                || e.getClickedBlock().getType() == Material.LIME_BED
                || e.getClickedBlock().getType() == Material.PINK_BED
                || e.getClickedBlock().getType() == Material.GRAY_BED
                || e.getClickedBlock().getType() == Material.LIGHT_GRAY_BED
                || e.getClickedBlock().getType() == Material.CYAN_BED
                || e.getClickedBlock().getType() == Material.PURPLE_BED
                || e.getClickedBlock().getType() == Material.BLUE_BED
                || e.getClickedBlock().getType() == Material.BROWN_BED
                || e.getClickedBlock().getType() == Material.GREEN_BED
                || e.getClickedBlock().getType() == Material.RED_BED
                || e.getClickedBlock().getType() == Material.BLACK_BED
                || e.getClickedBlock().getType() == Material.SHULKER_BOX
                || e.getClickedBlock().getType() == Material.WHITE_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.ORANGE_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.MAGENTA_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.LIGHT_BLUE_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.YELLOW_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.LIME_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.PINK_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.GRAY_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.LIGHT_GRAY_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.CYAN_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.PURPLE_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.BLUE_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.BROWN_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.GREEN_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.RED_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.BLACK_SHULKER_BOX
                || e.getClickedBlock().getType() == Material.LOOM
                || e.getClickedBlock().getType() == Material.STONECUTTER
                || e.getClickedBlock().getType() == Material.BARREL
                || e.getClickedBlock().getType() == Material.SMOKER
                || e.getClickedBlock().getType() == Material.BLAST_FURNACE
                || e.getClickedBlock().getType() == Material.CARTOGRAPHY_TABLE
                || e.getClickedBlock().getType() == Material.FLETCHING_TABLE
                || e.getClickedBlock().getType() == Material.GRINDSTONE
                || e.getClickedBlock().getType() == Material.SMITHING_TABLE
                || e.getClickedBlock().getType() == Material.REPEATER
                || e.getClickedBlock().getType() == Material.COMPARATOR
                || e.getClickedBlock().getType() == Material.LEVER
                || e.getClickedBlock().getType() == Material.HOPPER
                || e.getClickedBlock().getType() == Material.DAYLIGHT_DETECTOR
                || e.getClickedBlock().getType() == Material.LECTERN
                || e.getClickedBlock().getType() == Material.JUKEBOX
                || e.getClickedBlock().getType() == Material.NOTE_BLOCK
                || e.getClickedBlock().getType() == Material.BREWING_STAND
                || e.getClickedBlock().getType() == Material.OAK_DOOR
                || e.getClickedBlock().getType() == Material.SPRUCE_DOOR
                || e.getClickedBlock().getType() == Material.BIRCH_DOOR
                || e.getClickedBlock().getType() == Material.JUNGLE_DOOR
                || e.getClickedBlock().getType() == Material.ACACIA_DOOR
                || e.getClickedBlock().getType() == Material.DARK_OAK_DOOR
                || e.getClickedBlock().getType() == Material.CRIMSON_DOOR
                || e.getClickedBlock().getType() == Material.WARPED_DOOR
                || e.getClickedBlock().getType() == Material.OAK_FENCE_GATE
                || e.getClickedBlock().getType() == Material.SPRUCE_FENCE_GATE
                || e.getClickedBlock().getType() == Material.BIRCH_FENCE_GATE
                || e.getClickedBlock().getType() == Material.JUNGLE_FENCE_GATE
                || e.getClickedBlock().getType() == Material.ACACIA_FENCE_GATE
                || e.getClickedBlock().getType() == Material.DARK_OAK_FENCE_GATE
                || e.getClickedBlock().getType() == Material.CRIMSON_FENCE_GATE
                || e.getClickedBlock().getType() == Material.WARPED_FENCE_GATE
                || e.getClickedBlock().getType() == Material.STONE_BUTTON
                || e.getClickedBlock().getType() == Material.OAK_BUTTON
                || e.getClickedBlock().getType() == Material.SPRUCE_BUTTON
                || e.getClickedBlock().getType() == Material.BIRCH_BUTTON
                || e.getClickedBlock().getType() == Material.JUNGLE_BUTTON
                || e.getClickedBlock().getType() == Material.ACACIA_BUTTON
                || e.getClickedBlock().getType() == Material.DARK_OAK_BUTTON
                || e.getClickedBlock().getType() == Material.CRIMSON_BUTTON
                || e.getClickedBlock().getType() == Material.WARPED_BUTTON
                || e.getClickedBlock().getType() == Material.POLISHED_BLACKSTONE_BUTTON
                || e.getClickedBlock().getType() == Material.OAK_TRAPDOOR
                || e.getClickedBlock().getType() == Material.SPRUCE_TRAPDOOR
                || e.getClickedBlock().getType() == Material.BIRCH_TRAPDOOR
                || e.getClickedBlock().getType() == Material.JUNGLE_TRAPDOOR
                || e.getClickedBlock().getType() == Material.ACACIA_TRAPDOOR
                || e.getClickedBlock().getType() == Material.DARK_OAK_TRAPDOOR
                || e.getClickedBlock().getType() == Material.CRIMSON_TRAPDOOR
                || e.getClickedBlock().getType() == Material.COMPOSTER
                || e.getClickedBlock().getType() == Material.WARPED_TRAPDOOR))
            e.setCancelled(true);
    }
}