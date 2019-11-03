package me.jatinsingh.glt.Shop;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.jatinsingh.glt.Main;
import net.milkbowl.vault.economy.Economy;

public class GLTShopListener implements Listener {
	
	private Main plugin;
	private GLTShop gltShop;
	private Economy economy = Main.economy;
	
	public GLTShopListener(Main plugin) {
		this.plugin = plugin;
		gltShop = new GLTShop(this.plugin);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null)
			return;
		
		if(!e.getInventory().getName().equalsIgnoreCase(color("&4&lGodLike Tools")))
			return;
		
		if(e.getCurrentItem().getData().getItemType() == Material.AIR)
			return;
		
		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();
		int slot = e.getSlot();
		
		giveItem(p,slot);
	}
	
	public void giveItem(Player p, Integer slot) {
		
		File f = new File(plugin.getDataFolder(), "shop.yml");
		FileConfiguration c = YamlConfiguration.loadConfiguration(f);
		
		for(String key : c.getConfigurationSection("ShopGUI.Tools").getKeys(false)) {
			
			int shopSlot = c.getInt("ShopGUI.Tools." + key + ".Slot");
			
			if(shopSlot == slot) {
				if(isInventoryFull(p)) {
					double price = c.getDouble("ShopGUI.Tools." + key + ".Price");
					if(economy.has(p, price)) {
						p.getInventory().addItem(gltShop.toolType(key));
						economy.withdrawPlayer(p, price);
						p.sendMessage(plugin.prefix + color("Purchased " + key + " for&a " + price));
						return;
					}
					else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "You don't have enough balance.");
						return;
					}
				}
			}
		}
	}
	
	public boolean isInventoryFull(Player p) {
		int i = p.getInventory().firstEmpty();
		if(i == -1) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "Your inventory is full, didn't give the item.");
			return false;
		}
		return true;
	}
	
	private String color(String s) {
	    return ChatColor.translateAlternateColorCodes('&', s);
	}
}