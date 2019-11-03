package me.jatinsingh.glt.Tools;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class ItemCrafter {
	
	private Main plugin;
	
	public ItemCrafter(Main plugin) {
        this.plugin = plugin;
    }
	
	public ItemStack CraftingStick() {
		
		ItemStack ItemCrafter = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta ItemCrafterMeta = ItemCrafter.getItemMeta();
		ItemCrafterMeta.setDisplayName(color(plugin.getConfig().getString("Tools.ItemCrafter.display_name")));
		List<String> lore = plugin.getConfig().getStringList("Tools.ItemCrafter.lore");
		ItemCrafterMeta.setLore(color(lore));
		ItemCrafterMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ItemCrafter.setItemMeta(ItemCrafterMeta);
		ItemCrafter.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return ItemCrafter;
	}
	
	public boolean isCraftingStick(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.ItemCrafter.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.ItemCrafter.lore"));
				
				if(item.getItemMeta().getDisplayName().contains(name) && item.getItemMeta().getLore().containsAll(color(lore))) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private String color(String s){
	    return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	private List<String> color(List<String> lore){
	    return lore.stream().map(this::color).collect(Collectors.toList());
	}
}