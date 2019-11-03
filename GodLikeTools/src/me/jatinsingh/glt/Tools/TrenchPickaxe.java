package me.jatinsingh.glt.Tools;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class TrenchPickaxe {

	private Main plugin;
	
	public TrenchPickaxe(Main plugin) {
        this.plugin = plugin;
    }
	
	public ItemStack TrenchPickaxe3x3() {
		
		ItemStack TrenchPickaxe3x3 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta TrenchPickaxe3x3Meta = TrenchPickaxe3x3.getItemMeta();
		TrenchPickaxe3x3Meta.setDisplayName(color(plugin.getConfig().getString("Tools.TrenchPickaxe.3x3.display_name")));
		TrenchPickaxe3x3Meta.setLore(color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.3x3.lore")));
		if(plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe3x3Meta.spigot().setUnbreakable(true);
		}
		TrenchPickaxe3x3.setItemMeta(TrenchPickaxe3x3Meta);
		TrenchPickaxe3x3.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.TrenchPickaxe.3x3.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe3x3.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.TrenchPickaxe.3x3.UNBREAKING_LEVEL"));
		}
		return TrenchPickaxe3x3;
	}
	
	public ItemStack TrenchPickaxe5x5() {
		
		ItemStack TrenchPickaxe5x5 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta TrenchPickaxe5x5Meta = TrenchPickaxe5x5.getItemMeta();
		TrenchPickaxe5x5Meta.setDisplayName(color(plugin.getConfig().getString("Tools.TrenchPickaxe.5x5.display_name")));
		TrenchPickaxe5x5Meta.setLore(color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.5x5.lore")));
		if(plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe5x5Meta.spigot().setUnbreakable(true);
		}
		TrenchPickaxe5x5.setItemMeta(TrenchPickaxe5x5Meta);
		TrenchPickaxe5x5.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.TrenchPickaxe.5x5.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe5x5.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.TrenchPickaxe.5x5.UNBREAKING_LEVEL"));
		}
		return TrenchPickaxe5x5;
	}
	
	public ItemStack TrenchPickaxe7x7() {
		
		ItemStack TrenchPickaxe7x7 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta TrenchPickaxe7x7Meta = TrenchPickaxe7x7.getItemMeta();
		TrenchPickaxe7x7Meta.setDisplayName(color(plugin.getConfig().getString("Tools.TrenchPickaxe.7x7.display_name")));
		TrenchPickaxe7x7Meta.setLore(color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.7x7.lore")));
		if(plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe7x7Meta.spigot().setUnbreakable(true);
		}
		TrenchPickaxe7x7.setItemMeta(TrenchPickaxe7x7Meta);
		TrenchPickaxe7x7.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.TrenchPickaxe.7x7.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe7x7.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.TrenchPickaxe.7x7.UNBREAKING_LEVEL"));
		}
		return TrenchPickaxe7x7;
	}
	
	public ItemStack TrenchPickaxe9x9() {
		
		ItemStack TrenchPickaxe9x9 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta TrenchPickaxe9x9Meta = TrenchPickaxe9x9.getItemMeta();
		TrenchPickaxe9x9Meta.setDisplayName(color(plugin.getConfig().getString("Tools.TrenchPickaxe.9x9.display_name")));
		TrenchPickaxe9x9Meta.setLore(color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.9x9.lore")));
		if(plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe9x9Meta.spigot().setUnbreakable(true);
		}
		TrenchPickaxe9x9.setItemMeta(TrenchPickaxe9x9Meta);
		TrenchPickaxe9x9.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.TrenchPickaxe.9x9.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe9x9.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.TrenchPickaxe.9x9.UNBREAKING_LEVEL"));
		}
		return TrenchPickaxe9x9;
	}
	
	public ItemStack TrenchPickaxe11x11() {
		
		ItemStack TrenchPickaxe11x11 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta TrenchPickaxe11x11Meta = TrenchPickaxe11x11.getItemMeta();
		TrenchPickaxe11x11Meta.setDisplayName(color(plugin.getConfig().getString("Tools.TrenchPickaxe.11x11.display_name")));
		TrenchPickaxe11x11Meta.setLore(color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.11x11.lore")));
		if(plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe11x11Meta.spigot().setUnbreakable(true);
		}
		TrenchPickaxe11x11.setItemMeta(TrenchPickaxe11x11Meta);
		TrenchPickaxe11x11.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.TrenchPickaxe.11x11.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Unbreakable")) {
			TrenchPickaxe11x11.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.TrenchPickaxe.11x11.UNBREAKING_LEVEL"));
		}
		return TrenchPickaxe11x11;
	}
	
	public boolean isTrenchPickaxe3x3(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.TrenchPickaxe.3x3.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.3x3.lore"));
				
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
	
	public boolean isTrenchPickaxe5x5(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.TrenchPickaxe.5x5.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.5x5.lore"));
				
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
	
	public boolean isTrenchPickaxe7x7(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.TrenchPickaxe.7x7.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.7x7.lore"));
				
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
	
	public boolean isTrenchPickaxe9x9(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.TrenchPickaxe.9x9.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.9x9.lore"));
				
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
	
	public boolean isTrenchPickaxe11x11(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.TrenchPickaxe.11x11.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.TrenchPickaxe.11x11.lore"));
				
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
