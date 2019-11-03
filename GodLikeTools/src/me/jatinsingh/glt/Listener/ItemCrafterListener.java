package me.jatinsingh.glt.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.Tools.ItemCrafter;

public class ItemCrafterListener implements Listener {
	
	private Main plugin;
	private ItemCrafter itemCrafter;
	
	String prefix = ChatColor.RED + "[" + ChatColor.GRAY + "GLT" + ChatColor.RED + "] " + ChatColor.RESET;
	
	public ItemCrafterListener(Main plugin) {
        this.plugin = plugin;
        itemCrafter = new ItemCrafter(this.plugin);
    }
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(itemCrafter.isCraftingStick(p.getItemInHand())) {
				
				if(p.getInventory().contains(Material.GOLD_NUGGET) || p.getInventory().contains(Material.GOLD_INGOT)) {
					goldConvertInventory(p);
				}
				
				if(p.getInventory().contains(Material.IRON_INGOT)) {
					ironConvertInventory(p);
 				}
				
				if(p.getInventory().contains(Material.SAND) || p.getInventory().contains(Material.SULPHUR)) {
					tntConvertInventory(p);
				}
			}
		}
		
		if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if(itemCrafter.isCraftingStick(p.getItemInHand())) {
				BlockState state = e.getClickedBlock().getState();
				if (state instanceof Chest) {
					Chest chest = (Chest) state;
					Inventory inv = chest.getInventory();
					
					if (inv instanceof DoubleChestInventory) {
						DoubleChest doubleChest = (DoubleChest) inv.getHolder();
						inv = doubleChest.getInventory(); 
					}
					
					if(inv.contains(Material.IRON_INGOT))
						ironConvertChest(p,inv);
					if(inv.contains(Material.GOLD_NUGGET) || inv.contains(Material.GOLD_INGOT))
						goldConvertChest(p,inv);
					if(inv.contains(Material.SAND) && inv.contains(Material.SULPHUR))
						tntConvertChest(p,inv);
				}
			}
		}
	}
	
	public void tntConvertInventory(Player p) {
		
		int crafted_tnt = 0 , used_sand = 0 , used_gunpowder = 0;
		
		while(p.getInventory().containsAtLeast(new ItemStack(Material.SAND), 4) && p.getInventory().containsAtLeast(new ItemStack(Material.SULPHUR), 5)) {
			p.getInventory().removeItem(new ItemStack[] {new ItemStack(Material.SAND, 4)});
			p.getInventory().removeItem(new ItemStack[] {new ItemStack(Material.SULPHUR, 5)});
			p.getInventory().addItem(new ItemStack(Material.TNT,1));
			used_sand = used_sand + 4;
			used_gunpowder = used_gunpowder + 5;
			crafted_tnt = crafted_tnt + 1;
		}
		p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aCrafted &6" + crafted_tnt + " &aTNT using &6" + used_sand + " &aSand and &6" + used_gunpowder + " &aGunpowder!"));
	}
	
	public void tntConvertChest(Player p , Inventory inv) {
		
		int crafted_tnt = 0 , used_sand = 0 , used_gunpowder = 0;
		
		while(inv.containsAtLeast(new ItemStack(Material.SAND), 4) && inv.containsAtLeast(new ItemStack(Material.SULPHUR), 5)) {
			inv.removeItem(new ItemStack[] {new ItemStack(Material.SAND, 4)});
			inv.removeItem(new ItemStack[] {new ItemStack(Material.SULPHUR, 5)});
			inv.addItem(new ItemStack(Material.TNT,1));
			used_sand = used_sand + 4;
			used_gunpowder = used_gunpowder + 5;
			crafted_tnt = crafted_tnt + 1;
		}
		p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aCrafted &6" + crafted_tnt + " &aTNT using &6" + used_sand + " &aSand and &6" + used_gunpowder + " &aGunpowder!"));
	}
	
	public void goldConvertInventory(Player p) {
		
		int crafted_gold = 0 , left_gold_nugget = 0 , left_gold_ingot = 0;
		
        while(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 9)) {
        	p.getInventory().removeItem(new ItemStack[] {new ItemStack(Material.GOLD_NUGGET, 9)});
			p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT,1));
        }
        while(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 9)) {
        	p.getInventory().removeItem(new ItemStack[] {new ItemStack(Material.GOLD_INGOT, 9)});
        	p.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK,1));
        }
        
        ItemStack[] inv1 = p.getInventory().getContents();
         
        for(ItemStack i : inv1) {
            if(i != null && i.getType() == Material.GOLD_NUGGET) 
            	left_gold_nugget = left_gold_nugget + i.getAmount();
            if(i != null && i.getType() == Material.GOLD_INGOT)
            	left_gold_ingot = left_gold_ingot + i.getAmount();
            if(i != null && i.getType() == Material.GOLD_BLOCK)
            	crafted_gold = crafted_gold + i.getAmount();
        }
        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aCrafted&6 " + crafted_gold + " &aGold Blocks,&6 " + left_gold_ingot + " &aGold Ingots and&6 " + left_gold_nugget + " &aGold Nuggets."));
	}
	
	public void goldConvertChest(Player p , Inventory inv) {

		int crafted_gold = 0 , left_gold_nugget = 0 , left_gold_ingot = 0;
		
        while(inv.containsAtLeast(new ItemStack(Material.GOLD_NUGGET), 9)) {
        	inv.removeItem(new ItemStack[] {new ItemStack(Material.GOLD_NUGGET, 9)});
        	inv.addItem(new ItemStack(Material.GOLD_INGOT,1));
        }
        while(inv.containsAtLeast(new ItemStack(Material.GOLD_INGOT), 9)) {
        	inv.removeItem(new ItemStack[] {new ItemStack(Material.GOLD_INGOT, 9)});
        	inv.addItem(new ItemStack(Material.GOLD_BLOCK,1));
        }
        
        for(ItemStack i : inv) {
            if(i != null && i.getType() == Material.GOLD_NUGGET) 
            	left_gold_nugget = left_gold_nugget + i.getAmount();
            if(i != null && i.getType() == Material.GOLD_INGOT)
            	left_gold_ingot = left_gold_ingot + i.getAmount();
            if(i != null && i.getType() == Material.GOLD_BLOCK)
            	crafted_gold = crafted_gold + i.getAmount();
        }
        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aCrafted&6 " + crafted_gold + " &aGold Blocks,&6 " + left_gold_ingot + " &aGold Ingots and&6 " + left_gold_nugget + " &aGold Nuggets."));
	}
	
	public void ironConvertInventory(Player p) {
		
		int crafted_iron = 0 , left_iron_ingot = 0;
		
        while(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 9)) {
        	p.getInventory().removeItem(new ItemStack[] {new ItemStack(Material.IRON_INGOT, 9)});
			p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK,1));
        }
        
        ItemStack[] inv = p.getInventory().getContents();
        for(ItemStack i : inv) {
			if(i != null && i.getType() == Material.IRON_INGOT) 
				left_iron_ingot = left_iron_ingot + i.getAmount();
			if(i != null && i.getType() == Material.IRON_BLOCK) 
				crafted_iron = crafted_iron + i.getAmount();
		}
        
		p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aCrafted&6 " + crafted_iron + " &aIron Blocks and&6 " + left_iron_ingot + " &aIron Ingots."));
	}
	
	public void ironConvertChest(Player p, Inventory inv) {
		
		int crafted_blocks = 0, left_ingot = 0;
		while(inv.containsAtLeast(new ItemStack(Material.IRON_INGOT), 9)) {
			inv.removeItem(new ItemStack[] {new ItemStack(Material.IRON_INGOT, 9)});
			inv.addItem(new ItemStack(Material.IRON_BLOCK,1));
		}
		
		for(ItemStack i : inv) {
			if(i != null && i.getType() == Material.IRON_INGOT) 
				left_ingot = left_ingot + i.getAmount();
			if(i != null && i.getType() == Material.IRON_BLOCK) 
				crafted_blocks = crafted_blocks + i.getAmount();
		}
		p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aCrafted&6 " + crafted_blocks + " &aIron Blocks and&6 " + left_ingot + " &aIron Ingots.")); 
	}
}
