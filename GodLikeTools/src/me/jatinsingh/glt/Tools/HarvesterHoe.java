package me.jatinsingh.glt.Tools;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class HarvesterHoe {
	
	private Main plugin;
	
	public HarvesterHoe(Main plugin) {
        this.plugin = plugin;
    }
	
	public ItemStack HarvestHoe() {
		
		ItemStack HarvesterHoe = new ItemStack(Material.DIAMOND_HOE, 1);
		ItemMeta HarvesterHoeMeta = HarvesterHoe.getItemMeta();
		HarvesterHoeMeta.setDisplayName(color(plugin.getConfig().getString("Tools.HarvesterHoe.display_name")));
		HarvesterHoeMeta.setLore(color(plugin.getConfig().getStringList("Tools.HarvesterHoe.lore")));
		HarvesterHoe.setItemMeta(HarvesterHoeMeta);
		
		return HarvesterHoe;
	}
	
	public boolean isHarvesterHoe(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.HarvesterHoe.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.HarvesterHoe.lore"));
				
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
