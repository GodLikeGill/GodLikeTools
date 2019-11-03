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

public class LightningWand {
	
	private Main plugin;
	
	public LightningWand(Main plugin) {
		this.plugin = plugin;
	}		
	
	public ItemStack LightningStick() {
		
		ItemStack LightningStick = new ItemStack(Material.STICK, 1);
		ItemMeta LightningStickMeta = LightningStick.getItemMeta();
		LightningStickMeta.setDisplayName(color(plugin.getConfig().getString("Tools.LightningWand.display_name")));
		List<String> lore = plugin.getConfig().getStringList("Tools.LightningWand.lore");
		
		if(plugin.getConfig().getBoolean("Tools.LightningWand.Limited_Use.Enabled")) {
			lore.add("");
			lore.add(color("&aUses left: &c" + plugin.getConfig().getInt("Tools.LightningWand.Limited_Use.Number_of_Uses")));
		}
		
		LightningStickMeta.setLore(color(lore));
		LightningStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		LightningStick.setItemMeta(LightningStickMeta);
		LightningStick.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return LightningStick;
	}
	
	public boolean isLightningStick(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.LightningWand.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.LightningWand.lore"));
				
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