package me.jatinsingh.glt.Tools;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class SandWand {
	
	private Main plugin;
	
	public SandWand(Main plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack SandRemover() {
		
		ItemStack SandRemover = new ItemStack(Material.DIAMOND_HOE, 1);
		ItemMeta SandRemoverMeta = SandRemover.getItemMeta();
		SandRemoverMeta.setDisplayName(color(plugin.getConfig().getString("Tools.SandWand.display_name")));
		SandRemoverMeta.setLore(color(plugin.getConfig().getStringList("Tools.SandWand.lore")));
		SandRemover.setItemMeta(SandRemoverMeta);
		
		return SandRemover;
	}
	
	public boolean isSandWand(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.SandWand.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.SandWand.lore"));
				
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
