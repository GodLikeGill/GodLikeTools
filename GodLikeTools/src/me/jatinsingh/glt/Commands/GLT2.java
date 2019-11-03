package me.jatinsingh.glt.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.ChunkBuster.ChunkBuster;
import me.jatinsingh.glt.Tools.BlastShovel;
import me.jatinsingh.glt.Tools.HarvesterHoe;
import me.jatinsingh.glt.Tools.ItemCrafter;
import me.jatinsingh.glt.Tools.LightningWand;
import me.jatinsingh.glt.Tools.SandWand;
import me.jatinsingh.glt.Tools.TrayPickaxe;
import me.jatinsingh.glt.Tools.TrenchPickaxe;

public class GLT2 {
	
	private Main plugin;
	private ItemCrafter itemCrafter;
	private HarvesterHoe harvesterHoe;
	private SandWand sandWallRemover;
	private TrayPickaxe trayPickaxe;
	private TrenchPickaxe trenchPickaxe;
	private BlastShovel blastShovel;
	private ChunkBuster chunkBuster;
	private LightningWand lightningWand;
	
	public GLT2(Main plugin) {
		this.plugin = plugin;
		itemCrafter = new ItemCrafter(this.plugin);
		harvesterHoe = new HarvesterHoe(this.plugin);
		sandWallRemover = new SandWand(this.plugin);
		trayPickaxe = new TrayPickaxe(this.plugin);
		chunkBuster = new ChunkBuster(this.plugin);
		trenchPickaxe = new TrenchPickaxe(this.plugin);
		blastShovel = new BlastShovel(this.plugin);
		lightningWand = new LightningWand(this.plugin);
	}
	
	public void TwoArgCmd(Player p, Player target, String arg0, String arg1) {
		
		switch(arg0.toLowerCase()) {
		
		case "itemcrafter":
			if(canGive(p,target))
				target.getInventory().addItem(itemCrafter.CraftingStick());
			break;
			
		case "harvesterhoe":
			if(canGive(p,target))
				target.getInventory().addItem(harvesterHoe.HarvestHoe());
			break;
			
		case "sandwand":
			if(canGive(p,target))
				target.getInventory().addItem(sandWallRemover.SandRemover());
			break;
			
		case "traypickaxe":
			if(canGive(p,target))
				target.getInventory().addItem(trayPickaxe.TrayPick());
			break;
			
		case "lightningwand":
			if(canGive(p,target))
				target.getInventory().addItem(lightningWand.LightningStick());
			break;
			
		case "chunkbustertier1":
			if(canGive(p,target))
				target.getInventory().addItem(chunkBuster.ChunkBusterTier1());
			break;
			
		case "chunkbustertier2":
			if(canGive(p,target))
				target.getInventory().addItem(chunkBuster.ChunkBusterTier2());
			break;
			
		case "chunkbustertier3":
			if(canGive(p,target))
				target.getInventory().addItem(chunkBuster.ChunkBusterTier3());
			break;
			
		case "trenchpickaxe3x3":
			if(canGive(p,target))
				target.getInventory().addItem(trenchPickaxe.TrenchPickaxe3x3());
			break;
			
		case "trenchpickaxe5x5":
			if(canGive(p,target))
				target.getInventory().addItem(trenchPickaxe.TrenchPickaxe5x5());
			break;
			
		case "trenchpickaxe7x7":
			if(canGive(p,target))
				target.getInventory().addItem(trenchPickaxe.TrenchPickaxe7x7());
			break;
			
		case "trenchpickaxe9x9":
			if(canGive(p,target))
				target.getInventory().addItem(trenchPickaxe.TrenchPickaxe9x9());
			break;
			
		case "trenchpickaxe11x11":
			if(canGive(p,target))
				target.getInventory().addItem(trenchPickaxe.TrenchPickaxe11x11());
			break;
			
		case "blastshovel3x3":
			if(canGive(p,target))
				p.getInventory().addItem(blastShovel.BlastShovel3x3());
			break;
			
		case "blastshovel5x5":
			if(canGive(p,target))
				target.getInventory().addItem(blastShovel.BlastShovel5x5());
			break;
			
		case "blastshovel7x7":
			if(canGive(p,target))
				target.getInventory().addItem(blastShovel.BlastShovel7x7());
			break;
			
		case "blastshovel9x9":
			if(canGive(p,target))
				target.getInventory().addItem(blastShovel.BlastShovel9x9());
			break;
			
		case "blastshovel11x11":
			if(canGive(p,target))
				target.getInventory().addItem(blastShovel.BlastShovel11x11());
			break;
		
		default:
			p.sendMessage(plugin.prefix + ChatColor.RED + "Incorrect Command, please check again.");
			break;
			
		}
	}
	
	public boolean canGive(Player p, Player target) {
		if(p.hasPermission("glt.give")) {
			int i = target.getInventory().firstEmpty();
			if(i == -1) {
				p.sendMessage(plugin.prefix + ChatColor.DARK_RED + target.getName() + ChatColor.RED + "'s inventory is full and didn't receive the item.");
				return false;
			}
			return true;
		}
		else {
			p.sendMessage(plugin.prefix + ChatColor.RED + "You don't have permission to use this.");
			return false;
		}
	}
}
