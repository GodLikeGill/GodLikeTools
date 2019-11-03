package me.jatinsingh.glt.Listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Tools.HarvesterHoe;

public class HarvesterHoeListener implements Listener {
	
	private Main plugin;
	private HarvesterHoe harvesterHoe;
	
	public HarvesterHoeListener(Main plugin) {
		this.plugin = plugin;
		harvesterHoe = new HarvesterHoe(this.plugin);
	}
	
	@EventHandler
	public void onSugarCaneBreak(BlockBreakEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(harvesterHoe.isHarvesterHoe(p.getItemInHand())) {
			
			if(e.getBlock().getType() == Material.SUGAR_CANE_BLOCK) {
				
				e.setCancelled(true);
				
				p.getInventory().addItem(new ItemStack(Material.SUGAR_CANE , 1));
				
				Block b1 = e.getBlock().getRelative(0, 1, 0);
				Block b2 = e.getBlock().getRelative(0, 2, 0);
				
				if(b2.getType() == Material.SUGAR_CANE_BLOCK) {
					p.getInventory().addItem(new ItemStack(Material.SUGAR_CANE , 1));
					b2.setType(Material.AIR);
				}
				if(b1.getType() == Material.SUGAR_CANE_BLOCK) {
					p.getInventory().addItem(new ItemStack(Material.SUGAR_CANE , 1));
					b1.setType(Material.AIR);
				}
				e.getBlock().setType(Material.AIR);
			}
		}
	}
}
