package me.jatinsingh.glt.ChunkBuster;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;

public class ChunkBusterListener implements Listener {
	
	private Main plugin;
	private ChunkBuster chunkBuster;
	
	public ChunkBusterListener(Main plugin) {
		this.plugin = plugin;
		chunkBuster = new ChunkBuster(this.plugin);
	}
	
	@EventHandler
	public void onChunkBusterUse(PlayerInteractEvent e) {
		
		if(e.getAction() == Action.PHYSICAL)
			return;
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			
			Player p = (Player) e.getPlayer();
			
			if(chunkBuster.isChunkBusterTier1(p.getItemInHand())) {
				ChunkBusterGUI(p,chunkBuster.ChunkBusterTier1());
			}
			if(chunkBuster.isChunkBusterTier2(p.getItemInHand())) {
				ChunkBusterGUI(p,chunkBuster.ChunkBusterTier2());
			}
			if(chunkBuster.isChunkBusterTier3(p.getItemInHand())) {
				ChunkBusterGUI(p,chunkBuster.ChunkBusterTier3());
			}
		}
	}
	
	@EventHandler
	public void onChunkBusterPlace(BlockPlaceEvent e) {
		Player p = (Player) e.getPlayer();
		if(chunkBuster.isChunkBusterTier1(p.getItemInHand()) || chunkBuster.isChunkBusterTier2(p.getItemInHand()) || chunkBuster.isChunkBusterTier3(p.getItemInHand())) {
			e.setCancelled(true);
		}
	}
	
	private void ChunkBusterGUI(Player p, ItemStack item) {
		
		Inventory inv = Bukkit.getServer().createInventory(null, 9 , color("&4&lConfirm ChunkBuster"));
		
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE , 1 , (byte) 15);
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName("");
		glass.setItemMeta(glassMeta);
		
		ItemStack greenglass = new ItemStack(Material.STAINED_GLASS_PANE , 1 , (byte) 13);
		ItemMeta greenglassMeta = greenglass.getItemMeta();
		greenglassMeta.setDisplayName(color("&aConfirm"));
		greenglass.setItemMeta(greenglassMeta);
		
		ItemStack redglass = new ItemStack(Material.STAINED_GLASS_PANE , 1 , (byte) 14);
		ItemMeta redglassMeta = redglass.getItemMeta();
		redglassMeta.setDisplayName(color("&cDeny"));
		redglass.setItemMeta(redglassMeta);
		
		inv.setItem(0, greenglass);
		inv.setItem(8, redglass);
		inv.setItem(4, item);
		
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);
		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		
		p.openInventory(inv);
	}
	
	private String color(String s) {
	    return ChatColor.translateAlternateColorCodes('&', s);
	}
}