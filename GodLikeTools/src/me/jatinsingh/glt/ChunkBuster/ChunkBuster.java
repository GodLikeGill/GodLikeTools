package me.jatinsingh.glt.ChunkBuster;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class ChunkBuster {
	
	private Main plugin;
	
	public ChunkBuster(Main plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack ChunkBusterTier1() {
		
		ItemStack ChunkBusterTier1 = new ItemStack(Material.ENDER_PORTAL_FRAME, 1);
		ItemMeta ChunkBusterTier1Meta = ChunkBusterTier1.getItemMeta();
		ChunkBusterTier1Meta.setDisplayName(color(plugin.getConfig().getString("Tools.ChunkBuster.Tier1.display_name")));
		List<String> lore = plugin.getConfig().getStringList("Tools.ChunkBuster.Tier1.lore");
		ChunkBusterTier1Meta.setLore(color(lore));
		ChunkBusterTier1Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ChunkBusterTier1.setItemMeta(ChunkBusterTier1Meta);
		ChunkBusterTier1.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return ChunkBusterTier1;
	}
	
	public ItemStack ChunkBusterTier2() {
		
		ItemStack ChunkBusterTier2 = new ItemStack(Material.ENDER_PORTAL_FRAME, 1);
		ItemMeta ChunkBusterTier2Meta = ChunkBusterTier2.getItemMeta();
		ChunkBusterTier2Meta.setDisplayName(color(plugin.getConfig().getString("Tools.ChunkBuster.Tier2.display_name")));
		List<String> lore = plugin.getConfig().getStringList("Tools.ChunkBuster.Tier2.lore");
		ChunkBusterTier2Meta.setLore(color(lore));
		ChunkBusterTier2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ChunkBusterTier2.setItemMeta(ChunkBusterTier2Meta);
		ChunkBusterTier2.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return ChunkBusterTier2;
	}
	
	public ItemStack ChunkBusterTier3() {
		
		ItemStack ChunkBusterTier3 = new ItemStack(Material.ENDER_PORTAL_FRAME, 1);
		ItemMeta ChunkBusterTier3Meta = ChunkBusterTier3.getItemMeta();
		ChunkBusterTier3Meta.setDisplayName(color(plugin.getConfig().getString("Tools.ChunkBuster.Tier3.display_name")));
		List<String> lore = plugin.getConfig().getStringList("Tools.ChunkBuster.Tier3.lore");
		ChunkBusterTier3Meta.setLore(color(lore));
		ChunkBusterTier3Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ChunkBusterTier3.setItemMeta(ChunkBusterTier3Meta);
		ChunkBusterTier3.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return ChunkBusterTier3;
	}
	
	public boolean isChunkBusterTier1(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.ChunkBuster.Tier1.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.ChunkBuster.Tier1.lore"));
				
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
	
	public boolean isChunkBusterTier2(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.ChunkBuster.Tier2.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.ChunkBuster.Tier2.lore"));
				
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
	
	public boolean isChunkBusterTier3(ItemStack item) {
		
		if(item.hasItemMeta()) {
			
			if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
				
				String name = color(plugin.getConfig().getString("Tools.ChunkBuster.Tier3.display_name"));
				List<String> lore = color(plugin.getConfig().getStringList("Tools.ChunkBuster.Tier3.lore"));
				
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
