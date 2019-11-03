package me.jatinsingh.glt.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Shop.GLTShop;

public class GLT1 {
	
	private Main plugin;
	private GLTShop gltShop;
	
	public GLT1(Main plugin) {
		this.plugin = plugin;
		gltShop = new GLTShop(this.plugin);
	}
	
	public void OneArgCmd(Player p,String arg0) {
		
		switch(arg0.toLowerCase()) {
		
		case "itemcrafter":
		case "harvesterhoe":
		case "sandwand":
		case "traypickaxe":
		case "chunkbustertier1":
		case "chunkbustertier2":
		case "chunkbustertier3":
		case "trenchpickaxe3x3":
		case "trenchpickaxe5x5":			
		case "trenchpickaxe7x7":
		case "trenchpickaxe9x9":
		case "trenchpickaxe11x11":
		case "blastshovel3x3":
		case "blastshovel5x5":
		case "blastshovel7x7":
		case "blastshovel9x9":
		case "blastshovel11x11":
			p.sendMessage(plugin.prefix + ChatColor.RED + "Please specify a player");
			break;
			
		case "shop":
			if(p.hasPermission("glt.shop")) {
				gltShop.shopGUI(p);
				break;
			}
			else {
				p.sendMessage(plugin.prefix + ChatColor.RED + "You don't have permission to use this.");
				break;
			}
			
		case "reloadconfig":
			if(p.hasPermission("glt.reloadconfig")) {
				plugin.reloadConfig();
				plugin.saveConfig();
				p.sendMessage(plugin.prefix + ChatColor.GREEN + "Config has been Reloaded.");
				break;
			}
			else {
				p.sendMessage(plugin.prefix + ChatColor.RED + "You don't have permission to use this.");
				break;
			}
			
		case "reloadshop":
			if(p.hasPermission("glt.reloadshop")) {
				File f = new File(plugin.getDataFolder(), "shop.yml");
				FileConfiguration c = YamlConfiguration.loadConfiguration(f);
				try {
					c.save(f);p.sendMessage(plugin.prefix + ChatColor.GREEN + "Shop file has been Reloaded.");
					break;
				} catch (IOException e) {
					p.sendMessage(plugin.prefix + ChatColor.RED + "Could not save Shop file.");
					e.printStackTrace();
					break;
				}
			}
			else {
				p.sendMessage(plugin.prefix + ChatColor.RED + "You don't have permission to use this.");
				break;
			}
			
			
		case "help":
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
					"&9&m----------------&r&b GodLikeTools &9&m----------------" +
			                "\n&r&6* &7/glt reloadconfig : &8Reload configuration file." +
			                "\n&r&6* &7/glt reloadshop : &8Reload shop file." +
							"\n&r&6* &7/glt itemcrafter <player>" +
							"\n&r&6* &7/glt harvesterhoe <player>" +
							"\n&r&6* &7/glt sandwand <player>" +
							"\n&r&6* &7/glt lightningwand <player>" +
							"\n&r&6* &7/glt traypickaxe <player>" +
							"\n&r&6* &7/glt chunkbustertier1-3 <player>" +
							"\n&r&6* &7/glt blastshovel3x3-11x11 <player>" +
							"\n&r&6* &7/glt trenchpickaxe3x3-11x11 <player>" +
					"\n&9&m--------------------------------------------"));
			break;
		
		default:
			p.sendMessage(plugin.prefix + ChatColor.RED + "Incorrect Command, please check again.");
			break;
		}
	}
}
