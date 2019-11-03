package me.jatinsingh.glt.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Tools.SandWand;

public class SandWandListener implements Listener {
	
	private Main plugin;
	private SandWand sandWand;
	
	public SandWandListener(Main plugin) {
		this.plugin = plugin;
		sandWand = new SandWand(this.plugin);
	}
	String prefix = ChatColor.RED + "[" + ChatColor.GRAY + "GLT" + ChatColor.RED + "] " + ChatColor.RESET;
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(sandWand.isSandWand(p.getItemInHand())) {
				
				Block block = e.getClickedBlock();
				
				if(block.getType() == Material.SAND) {
					
					int i = 0;
					int j = -1;
					
					while(block.getRelative(0,i,0).getType() == Material.SAND) {
						block.getRelative(0,i,0).setType(Material.AIR);
						i++;
					}
					
					while(block.getRelative(0,j,0).getType() == Material.SAND) {
						block.getRelative(0,j,0).setType(Material.AIR);
						j--;
					}
					
				}
				else {
					p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&',"&cYou can only use this for Sand Walls."));
					return;
				}
			}
		}
	}
}
