package me.jatinsingh.glt.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.massivecraft.factions.integration.Worldguard;
import com.massivecraft.factions.listeners.FactionsBlockListener;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Tools.BlastShovel;

public class BlastShovelListener implements Listener {
	
	private Main plugin;
	private BlastShovel blastShovel;
	
	public BlastShovelListener(Main plugin) {
		this.plugin = plugin;
		blastShovel = new BlastShovel(this.plugin);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		Block b = e.getBlock();
		
		if(blastShovel.isBlastShovel3x3(p.getItemInHand())) {
			int radius = 1;
			blasting(b,p,radius);
		}
		if(blastShovel.isBlastShovel5x5(p.getItemInHand())) {
			int radius = 2;
			blasting(b,p,radius);
		}
		if(blastShovel.isBlastShovel7x7(p.getItemInHand())) {
			int radius = 3;
			blasting(b,p,radius);
		}
		if(blastShovel.isBlastShovel9x9(p.getItemInHand())) {
			int radius = 4;
			blasting(b,p,radius);
		}
		if(blastShovel.isBlastShovel11x11(p.getItemInHand())) {
			int radius = 5;
			blasting(b,p,radius);
		}
	}
	
	public void blasting(Block b ,Player p, Integer r) {
		for(int i=-r;i<=r;i++) {
			for(int j=-r;j<=r;j++) {
				for(int k=-r;k<=r;k++) {
					
					boolean breakable = true;
					Location loc = b.getRelative(i, j, k).getLocation();
					
					if(plugin.WorldGuard.isEnabled() && plugin.WorldGuard != null) {
						if(Worldguard.playerCanBuild(p, loc)) {
							breakable = false;
						}
					}
					
					if (plugin.factions != null && plugin.factions.isEnabled()) {
						if(!FactionsBlockListener.playerCanBuildDestroyBlock(p, loc, "break", true)) {
							breakable = false;
						}
					}
					
					for(String s : plugin.getConfig().getStringList("Tools.BlastShovel.Blacklisted_Blocks")) {
						if(b.getRelative(i, j, k).getType() == Material.getMaterial(s)) {
							breakable = false;
						}
					}
					
					if(breakable == false)
						break;
					
					if(plugin.getConfig().getBoolean("Tools.BlastShovel.Drop_Blocks")) {
						b.getRelative(i, j, k).breakNaturally();
					}
					if(!plugin.getConfig().getBoolean("Tools.BlastShovel.Drop_Blocks")){
						b.getRelative(i, j, k).setType(Material.AIR);
					}
				}
			}
		}
	}
}
