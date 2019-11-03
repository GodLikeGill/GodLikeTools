package me.jatinsingh.glt.ChunkBuster;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.integration.Worldguard;
import com.massivecraft.factions.listeners.FactionsBlockListener;

import me.jatinsingh.glt.Main;

public class ChunkBusterGUIListener implements Listener {
	
	private Main plugin;
	private ChunkBuster chunkBuster;
	
	
	public ChunkBusterGUIListener(Main plugin) {
		this.plugin = plugin;
		chunkBuster = new ChunkBuster(this.plugin);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null)
			return;
		
		if(!e.getInventory().getName().equalsIgnoreCase(color("&4&lConfirm ChunkBuster")))
			return;
		
		if(e.getCurrentItem().getData().getItemType() == Material.AIR)
			return;
		
		e.setCancelled(true);
		
		ItemStack item = e.getInventory().getItem(4);
		Player p = (Player) e.getWhoClicked();
		
		if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Confirm")) {
				
				if(chunkBuster.isChunkBusterTier1(item)) {
					timeBeforeCB(p,plugin.getConfig().getInt("Tools.ChunkBuster.Tier1.Delay_Time"), p.getLocation(), item);
				}
				if(chunkBuster.isChunkBusterTier2(item)) {
					timeBeforeCB(p,plugin.getConfig().getInt("Tools.ChunkBuster.Tier2.Delay_Time"), p.getLocation(), item);
				}
				if(chunkBuster.isChunkBusterTier3(item)) {
					timeBeforeCB(p,plugin.getConfig().getInt("Tools.ChunkBuster.Tier3.Delay_Time"), p.getLocation(), item);
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Deny")) {
				p.closeInventory();
			}
		}
	}
	
	public void timeBeforeCB(Player p, Integer time, Location loc, ItemStack item) {
		
		p.closeInventory();
		
		if (plugin.cbTime.containsKey(p.getName())) {
			p.sendMessage(plugin.prefix + color("&cYou can only use 1 Chunk Buster at a time, Wait for it to finish."));
			return;
		}
		
		p.getInventory().removeItem(item);
		
		if(!plugin.getConfig().getBoolean("Tools.ChunkBuster.Time_To_Evacuate.Enabled")) {
			ChunkBusting(p,time,loc);
			return;
		}
		int evactime = plugin.getConfig().getInt("Tools.ChunkBuster.Time_To_Evacuate.time_in_seconds");
		
		plugin.cbTime.put(p.getName(), evactime);
		plugin.cbTask.put(p.getName(), new BukkitRunnable(){
			public void run() {
				plugin.cbTime.put(p.getName(), plugin.cbTime.get(p.getName()) - 1);
				if (plugin.cbTime.get(p.getName()) == 0) {
					plugin.cbTime.remove(p.getName());
					plugin.cbTask.remove(p.getName());
					cancel();
					ChunkBusting(p,time,loc);
				}
				else {
					if(plugin.cbTime.get(p.getName()) == evactime-1)
						p.sendMessage(plugin.prefix + color("&e&lWARNING &c&l! &r&7Evacuate chunk before it is mined in &e" + plugin.cbTime.get(p.getName()) + " &7seconds."));
					if(plugin.cbTime.get(p.getName()) <= 5)
						p.sendMessage(plugin.prefix + color("&e&lWARNING &c&l! &r&7Evacuate chunk before it is mined in &e" + plugin.cbTime.get(p.getName()) + " &7seconds."));
				}
			}
		});
		plugin.cbTask.get(p.getName()).runTaskTimer(plugin, 20, 20);
	}
	
	public void ChunkBusting(Player p, Integer time, Location loc) {
		
		if(plugin.WorldGuard.isEnabled() && plugin.WorldGuard != null) {
			if(Worldguard.playerCanBuild(p, loc)) {
				p.sendMessage(plugin.prefix + ChatColor.RED + "You can't use this on this chunk.");
				return;
			}
		}
		
		if (plugin.factions != null && plugin.factions.isEnabled()) {
			if(!FactionsBlockListener.playerCanBuildDestroyBlock(p, loc, "break", true)) {
				p.sendMessage(plugin.prefix + ChatColor.RED + "You can't use this on this chunk.");
				return;
			}
		}
		
		plugin.chunk.put(p.getName(), loc.getChunk());
		plugin.cbTime.put(p.getName(), loc.getBlockY());
		plugin.cbTask.put(p.getName(), new BukkitRunnable() {
			public void run() {
				plugin.cbTime.put(p.getName(), plugin.cbTime.get(p.getName()) - 1);
				
				if (plugin.cbTime.get(p.getName()) <= 0 ) {
					p.sendMessage(plugin.prefix + color("&aChunkBuster has finished mining the chunk."));
					plugin.cbTime.remove(p.getName());
					plugin.cbTask.remove(p.getName());
					plugin.chunk.remove(p.getName());
					cancel();
				}
				else {
					for (int x = 0; x < 16; x++) {
						for(int z = 0; z < 16 ; z++) {
							if(!(plugin.chunk.get(p.getName()).getBlock(x, plugin.cbTime.get(p.getName()), z).getType() == Material.BEDROCK)) {
								plugin.chunk.get(p.getName()).getBlock(x, plugin.cbTime.get(p.getName()), z).setType(Material.AIR);
							}
						}
					}
				}
			}
		});
		plugin.cbTask.get(p.getName()).runTaskTimer(plugin, 20, time);
	}
	
	private String color(String s) {
	    return ChatColor.translateAlternateColorCodes('&', s);
	}
}