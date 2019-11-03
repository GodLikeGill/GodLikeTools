package me.jatinsingh.glt.Tools;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class TrayPickaxe {
	
private Main plugin;
	
	public TrayPickaxe(Main plugin) {
        this.plugin = plugin;
    }
	
	public ItemStack TrayPick() {
		
		ItemStack TrayPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta TrayPickaxeMeta = TrayPickaxe.getItemMeta();
		TrayPickaxeMeta.setDisplayName(color(plugin.getConfig().getString("Tools.TrayPickaxe.display_name")));
		TrayPickaxeMeta.setLore(color(plugin.getConfig().getStringList("Tools.TrayPickaxe.lore")));
		TrayPickaxe.setItemMeta(TrayPickaxeMeta);
		
		return TrayPickaxe;
	}
	
	public boolean isTrayPick(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.TrayPickaxe.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.TrayPickaxe.lore"));
				
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
