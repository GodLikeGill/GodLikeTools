package me.jatinsingh.glt.ChunkBuster;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import me.jatinsingh.glt.Main;

public class ChunkBusterWFListener implements Listener {	
	
	private Main plugin;
	
	public ChunkBusterWFListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onWaterFlow(BlockFromToEvent e) {
		if(e.getBlock().getType() == Material.STATIONARY_WATER || e.getBlock().getType() == Material.WATER || e.getBlock().getType() == Material.STATIONARY_LAVA || e.getBlock().getType() == Material.LAVA) {
			for (Chunk chunk : plugin.chunk.values()) {
			    if(chunk == e.getToBlock().getChunk()) {
			    	e.setCancelled(true);
			    }
			}
		}
	}
}