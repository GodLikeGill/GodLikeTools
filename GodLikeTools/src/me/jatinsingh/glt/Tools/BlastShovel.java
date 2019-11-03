package me.jatinsingh.glt.Tools;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class BlastShovel {
	
	private Main plugin;
	
	public BlastShovel(Main plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack BlastShovel3x3() {
		
		ItemStack BlastShovel3x3 = new ItemStack(Material.DIAMOND_SPADE, 1);
		ItemMeta BlastShovel3x3Meta = BlastShovel3x3.getItemMeta();
		BlastShovel3x3Meta.setDisplayName(color(plugin.getConfig().getString("Tools.BlastShovel.3x3.display_name")));
		BlastShovel3x3Meta.setLore(color(plugin.getConfig().getStringList("Tools.BlastShovel.3x3.lore")));
		if(plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel3x3Meta.spigot().setUnbreakable(true);
		}
		BlastShovel3x3.setItemMeta(BlastShovel3x3Meta);
		BlastShovel3x3.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.BlastShovel.3x3.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel3x3.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.BlastShovel.3x3.UNBREAKING_LEVEL"));
		}
		
		return BlastShovel3x3;
	}
	
	public ItemStack BlastShovel5x5() {
		
		ItemStack BlastShovel5x5 = new ItemStack(Material.DIAMOND_SPADE, 1);
		ItemMeta BlastShovel5x5Meta = BlastShovel5x5.getItemMeta();
		BlastShovel5x5Meta.setDisplayName(color(plugin.getConfig().getString("Tools.BlastShovel.5x5.display_name")));
		BlastShovel5x5Meta.setLore(color(plugin.getConfig().getStringList("Tools.BlastShovel.5x5.lore")));
		if(plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel5x5Meta.spigot().setUnbreakable(true);
		}
		BlastShovel5x5.setItemMeta(BlastShovel5x5Meta);
		BlastShovel5x5.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.BlastShovel.5x5.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel5x5.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.BlastShovel.5x5.UNBREAKING_LEVEL"));
		}
		
		return BlastShovel5x5;
	}
	
	public ItemStack BlastShovel7x7() {
		
		ItemStack BlastShovel7x7 = new ItemStack(Material.DIAMOND_SPADE, 1);
		ItemMeta BlastShovel7x7Meta = BlastShovel7x7.getItemMeta();
		BlastShovel7x7Meta.setDisplayName(color(plugin.getConfig().getString("Tools.BlastShovel.7x7.display_name")));
		BlastShovel7x7Meta.setLore(color(plugin.getConfig().getStringList("Tools.BlastShovel.7x7.lore")));
		if(plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel7x7Meta.spigot().setUnbreakable(true);
		}
		BlastShovel7x7.setItemMeta(BlastShovel7x7Meta);
		BlastShovel7x7.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.BlastShovel.7x7.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel7x7.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.BlastShovel.7x7.UNBREAKING_LEVEL"));
		}
		
		return BlastShovel7x7;
	}
	
	public ItemStack BlastShovel9x9() {
		
		ItemStack BlastShovel9x9 = new ItemStack(Material.DIAMOND_SPADE, 1);
		ItemMeta BlastShovel9x9Meta = BlastShovel9x9.getItemMeta();
		BlastShovel9x9Meta.setDisplayName(color(plugin.getConfig().getString("Tools.BlastShovel.9x9.display_name")));
		BlastShovel9x9Meta.setLore(color(plugin.getConfig().getStringList("Tools.BlastShovel.9x9.lore")));
		if(plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel9x9Meta.spigot().setUnbreakable(true);
		}
		BlastShovel9x9.setItemMeta(BlastShovel9x9Meta);
		BlastShovel9x9.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.BlastShovel.9x9.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel9x9.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.BlastShovel.9x9.UNBREAKING_LEVEL"));
		}
		
		return BlastShovel9x9;
	}
	
	public ItemStack BlastShovel11x11() {
		
		ItemStack BlastShovel11x11 = new ItemStack(Material.DIAMOND_SPADE, 1);
		ItemMeta BlastShovel11x11Meta = BlastShovel11x11.getItemMeta();
		BlastShovel11x11Meta.setDisplayName(color(plugin.getConfig().getString("Tools.BlastShovel.11x11.display_name")));
		BlastShovel11x11Meta.setLore(color(plugin.getConfig().getStringList("Tools.BlastShovel.11x11.lore")));
		if(plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel11x11Meta.spigot().setUnbreakable(true);
		}
		BlastShovel11x11.setItemMeta(BlastShovel11x11Meta);
		BlastShovel11x11.addUnsafeEnchantment(Enchantment.DIG_SPEED, plugin.getConfig().getInt("Tools.BlastShovel.11x11.EFFECIENCY_LEVEL"));
		if(!plugin.getConfig().getBoolean("Tools.BlastShovel.Unbreakable")) {
			BlastShovel11x11.addUnsafeEnchantment(Enchantment.DURABILITY, plugin.getConfig().getInt("Tools.BlastShovel.11x11.UNBREAKING_LEVEL"));
		}
		
		return BlastShovel11x11;
	}
	
	public boolean isBlastShovel3x3(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.BlastShovel.3x3.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.BlastShovel.3x3.lore"));
				
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
	
	public boolean isBlastShovel5x5(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.BlastShovel.5x5.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.BlastShovel.5x5.lore"));
				
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
	
	public boolean isBlastShovel7x7(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.BlastShovel.7x7.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.BlastShovel.7x7.lore"));
				
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
	
	public boolean isBlastShovel9x9(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.BlastShovel.9x9.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.BlastShovel.9x9.lore"));
				
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
	
	public boolean isBlastShovel11x11(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.BlastShovel.11x11.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.BlastShovel.11x11.lore"));
				
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
