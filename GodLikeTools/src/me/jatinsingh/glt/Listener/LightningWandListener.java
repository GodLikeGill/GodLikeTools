package me.jatinsingh.glt.Listener;

import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Tools.LightningWand;

public class LightningWandListener implements Listener {
	
	private Main plugin;
	private LightningWand lightningWand;
	
	public LightningWandListener(Main plugin) {
		this.plugin = plugin;
		lightningWand = new LightningWand(this.plugin);
	}
	
	@EventHandler
	public void onLightningWandUse(PlayerInteractEvent e) {
		
		if(e.getAction() == Action.PHYSICAL)
			return;
		
		Player p = (Player) e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(lightningWand.isLightningStick(p.getItemInHand())) {
				p.getWorld().strikeLightning(p.getTargetBlock((Set<Material>) null, 5).getLocation());
				
				ItemStack wand = p.getItemInHand();
				ItemMeta wandMeta = wand.getItemMeta();
				List<String> lore = wandMeta.getLore();
				
				if(plugin.getConfig().getBoolean("Tools.LightningWand.Limited_Use.Enabled")) {
					for(int i = 0; i < lore.size(); i++) {
						if(lore.get(i).contains("Uses left: ")) {
							String uses = lore.get(i).substring(15);
							int uses1 = Integer.parseInt(uses);
							
							if(uses1 == 1) {
								p.getInventory().removeItem(p.getItemInHand());
								p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
							}
							
							int uses2 = uses1 - 1;
							lore.set(i, lore.get(i).replace("" + uses1, "" + uses2));
							wandMeta.setLore(lore);
							wand.setItemMeta(wandMeta);
						}
					}
				}
			}
		}
	}
}