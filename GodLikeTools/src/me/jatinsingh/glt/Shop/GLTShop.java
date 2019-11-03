package me.jatinsingh.glt.Shop;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jatinsingh.glt.Main;
import me.jatinsingh.glt.ChunkBuster.ChunkBuster;
import me.jatinsingh.glt.Tools.BlastShovel;
import me.jatinsingh.glt.Tools.HarvesterHoe;
import me.jatinsingh.glt.Tools.ItemCrafter;
import me.jatinsingh.glt.Tools.LightningWand;
import me.jatinsingh.glt.Tools.SandWand;
import me.jatinsingh.glt.Tools.TrayPickaxe;
import me.jatinsingh.glt.Tools.TrenchPickaxe;

public class GLTShop {
	
	private Main plugin;
	private ItemCrafter itemCrafter;
	private HarvesterHoe harvesterHoe;
	private SandWand sandWallRemover;
	private TrayPickaxe trayPickaxe;
	private TrenchPickaxe trenchPickaxe;
	private BlastShovel blastShovel;
	private ChunkBuster chunkBuster;
	private LightningWand lightningWand;
	
	public GLTShop(Main plugin) {
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
	
	public void shopGUI(Player p) {
		
		File f = new File(plugin.getDataFolder(), "shop.yml");
		FileConfiguration c = YamlConfiguration.loadConfiguration(f);
		
		Inventory inv = Bukkit.getServer().createInventory(null, c.getInt("ShopGUI.Rows")*9 , color("&4&lGodLike Tools"));
		
		ItemStack fill_empty = new ItemStack(Material.getMaterial(c.getString("ShopGUI.Fill_Empty_Slots.Type")), 1, (byte) c.getInt("ShopGUI.Fill_Empty_Slots.Color"));
		ItemMeta fill_empty_meta = fill_empty.getItemMeta();
		fill_empty_meta.setDisplayName(c.getString("ShopGUI.Fill_Empty_Slots.dispay_name"));
		fill_empty_meta.setLore(color(c.getStringList("ShopGUI.Fill_Empty_Slots.lore")));
		fill_empty.setItemMeta(fill_empty_meta);
		
		for(String key : c.getConfigurationSection("ShopGUI.Tools").getKeys(false)) {
			
			String toolName = c.getString("ShopGUI.Tools." + key);
			
			ItemStack item = toolType(toolName);
			ItemMeta itemMeta = item.getItemMeta();
			List<String> lore = itemMeta.getLore();
			lore.addAll(color(c.getStringList("ShopGUI.Tools." + key + ".lore")));
			for(int i = 0; i < lore.size(); i++) {
				if(lore.get(i).contains("%buy_price%")) {
					lore.set(i, lore.get(i).replace("%buy_price%", c.getString("ShopGUI.Tools." + key + ".Price")));
				}
			}
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
			
			inv.setItem(c.getInt("ShopGUI.Tools." + key + ".Slot"), item);
		}
		
		for (int i = 0; i < inv.getSize(); i++) {
			if(inv.getItem(i) == null) {
				inv.setItem(i, fill_empty);
			}
		}
		
		p.openInventory(inv);
	}
	
	public ItemStack toolType(String item) {
		
		if(item.contains("ChunkBusterTier1"))
			return chunkBuster.ChunkBusterTier1();
		
		if(item.contains("ChunkBusterTier2"))
			return chunkBuster.ChunkBusterTier2();
		
		if(item.contains("ChunkBusterTier3"))
			return chunkBuster.ChunkBusterTier3();
		
		if(item.contains("TrenchPickaxe3x3"))
			return trenchPickaxe.TrenchPickaxe3x3();
		
		if(item.contains("TrenchPickaxe5x5"))
			return trenchPickaxe.TrenchPickaxe5x5();
		
		if(item.contains("TrenchPickaxe7x7"))
			return trenchPickaxe.TrenchPickaxe7x7();
		
		if(item.contains("TrenchPickaxe9x9"))
			return trenchPickaxe.TrenchPickaxe9x9();
		
		if(item.contains("TrenchPickaxe11x11"))
			return trenchPickaxe.TrenchPickaxe11x11();
		
		if(item.contains("BlastShovel3x3"))
			return blastShovel.BlastShovel3x3();
		
		if(item.contains("BlastShovel5x5"))
			return blastShovel.BlastShovel5x5();
		
		if(item.contains("BlastShovel7x7"))
			return blastShovel.BlastShovel7x7();
		
		if(item.contains("BlastShovel9x9"))
			return blastShovel.BlastShovel9x9();
		
		if(item.contains("BlastShovel11x11"))
			return blastShovel.BlastShovel11x11();
		
		if(item.contains("HarvesterHoe"))
			return harvesterHoe.HarvestHoe();
		
		if(item.contains("ItemCrafter"))
			return itemCrafter.CraftingStick();
		
		if(item.contains("SandWand"))
			return sandWallRemover.SandRemover();
		
		if(item.contains("LightningWand"))
			return lightningWand.LightningStick();
		
		if(item.contains("TrayPickaxe"))
			return trayPickaxe.TrayPick();
		
		ItemStack noItem = new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte) 14);
		ItemMeta noItemMeta = noItem.getItemMeta();
		noItemMeta.setDisplayName(ChatColor.RED + "No Item");
		noItemMeta.setLore(Arrays.asList(ChatColor.DARK_RED + "Check Shop file, 'Item' section is not corrent."));
		noItem.setItemMeta(noItemMeta);
		
		return noItem;
	}
	
	private String color(String s){
	    return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	private List<String> color(List<String> lore){
	    return lore.stream().map(this::color).collect(Collectors.toList());
	}
}
