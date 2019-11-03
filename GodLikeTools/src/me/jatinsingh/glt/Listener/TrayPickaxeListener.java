package me.jatinsingh.glt.Listener;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Tools.TrayPickaxe;

public class TrayPickaxeListener implements Listener {
	
	private Main plugin;
	private TrayPickaxe trayPickaxe;
	
	String prefix = ChatColor.RED + "[" + ChatColor.GRAY + "GLT" + ChatColor.RED + "] " + ChatColor.RESET;
	
	public TrayPickaxeListener(Main plugin) {
		this.plugin = plugin;
		trayPickaxe = new TrayPickaxe(this.plugin);
	}
	
	@EventHandler
	public void onTrayPickUse(PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(e.getAction() == Action.LEFT_CLICK_BLOCK && trayPickaxe.isTrayPick(p.getItemInHand())) {
			
			Block B = e.getClickedBlock();
			List<String> buo = plugin.getConfig().getStringList("Tools.TrayPickaxe.Block_Used_On");
			
			if(buo.contains(B.getType().toString())) {
				
				for(int i = -1 ; i <= 1 ; i ++) {
					
					List<String> wlb = plugin.getConfig().getStringList("Tools.TrayPickaxe.Whitelisted_Blocks");
					
					if(wlb.contains(B.getRelative(i, 0, 0).getType().toString())) {
						if(!plugin.getConfig().getBoolean("Tools.TrayPickaxe.Drop_Blocks"))
							B.getRelative(i, 0, 0).setType(Material.AIR);
						if(plugin.getConfig().getBoolean("Tools.TrayPickaxe.Drop_Blocks"))
							B.getRelative(i, 0, 0).breakNaturally();
					}
					if(wlb.contains(B.getRelative(0, 0, i).getType().toString())) {
						if(!plugin.getConfig().getBoolean("Tools.TrayPickaxe.Drop_Blocks"))
							B.getRelative(0, 0, i).setType(Material.AIR);
						if(plugin.getConfig().getBoolean("Tools.TrayPickaxe.Drop_Blocks"))
							B.getRelative(0, 0, i).breakNaturally();
					}
				}
			}
			else {
				p.sendMessage(prefix + ChatColor.RED + "Tray pick works on " + buo.toString().replace("[","").replace("]","").replace(",",", ") + ".");
			}
		}
	}
}
