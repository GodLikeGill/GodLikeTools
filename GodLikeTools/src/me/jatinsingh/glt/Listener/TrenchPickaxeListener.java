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
import me.jatinsingh.glt.Tools.TrenchPickaxe;

public class TrenchPickaxeListener implements Listener {
	
	private Main plugin;
	private TrenchPickaxe trenchPickaxe;
	
	public TrenchPickaxeListener(Main plugin) {
		this.plugin = plugin;
		trenchPickaxe = new TrenchPickaxe(this.plugin);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		Block b = e.getBlock();
		
		if(trenchPickaxe.isTrenchPickaxe3x3(p.getItemInHand())) {
			int radius = 1;
			trenching(b,p,radius);
		}
		if(trenchPickaxe.isTrenchPickaxe5x5(p.getItemInHand())) {
			int radius = 2;
			trenching(b,p,radius);
		}
		if(trenchPickaxe.isTrenchPickaxe7x7(p.getItemInHand())) {
			int radius = 3;
			trenching(b,p,radius);
		}
		if(trenchPickaxe.isTrenchPickaxe9x9(p.getItemInHand())) {
			int radius = 4;
			trenching(b,p,radius);
		}
		if(trenchPickaxe.isTrenchPickaxe11x11(p.getItemInHand())) {
			int radius = 5;
			trenching(b,p,radius);
		}
	}
	
	public void trenching(Block b ,Player p, Integer r) {
		
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
					
					for(String s : plugin.getConfig().getStringList("Tools.TrenchPickaxe.Blacklisted_Blocks")) {
						if(b.getRelative(i, j, k).getType() == Material.getMaterial(s)) {
							breakable = false;
						}
					}
					
					if(breakable == false)
						break;
					
					if(plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Drop_Blocks")) {
						b.getRelative(i, j, k).breakNaturally();
					}
					if(!plugin.getConfig().getBoolean("Tools.TrenchPickaxe.Drop_Blocks")){
						b.getRelative(i, j, k).setType(Material.AIR);
					}
				}
			}
		}
	}
}
