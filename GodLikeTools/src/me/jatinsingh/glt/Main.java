package me.jatinsingh.glt;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.jatinsingh.glt.ChunkBuster.ChunkBusterGUIListener;
import me.jatinsingh.glt.ChunkBuster.ChunkBusterListener;
import me.jatinsingh.glt.ChunkBuster.ChunkBusterWFListener;
import me.jatinsingh.glt.Commands.GLT;
import me.jatinsingh.glt.Listener.BlastShovelListener;
import me.jatinsingh.glt.Listener.HarvesterHoeListener;
import me.jatinsingh.glt.Listener.ItemCrafterListener;
import me.jatinsingh.glt.Listener.LightningWandListener;
import me.jatinsingh.glt.Listener.SandWandListener;
import me.jatinsingh.glt.Listener.TrayPickaxeListener;
import me.jatinsingh.glt.Listener.TrenchPickaxeListener;
import me.jatinsingh.glt.Shop.GLTShopListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public String prefix = ChatColor.RED + "[" + ChatColor.GRAY + "GLT" + ChatColor.RED + "] " + ChatColor.RESET;
	
	public HashMap<String,Integer> cbTime = new HashMap<String,Integer>();
	public HashMap<String,BukkitRunnable> cbTask= new HashMap<String,BukkitRunnable>();
	public HashMap<String,Chunk> chunk = new HashMap<String,Chunk>();
	
	public static Economy economy = null;
	private GLT command1 = new GLT(this);
	public Plugin factions = getServer().getPluginManager().getPlugin("Factions");
	public Plugin WorldGuard = getServer().getPluginManager().getPlugin("WorldGuard");
	
	public void onEnable() {
		
		if(!setupEconomy()) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "No Economy set!");
		}
		
		if(getConfig().getName() != "config.yml") {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		
		File f = new File(getDataFolder(), "shop.yml");
		
		if (!f.exists()) {            
	         saveResource("shop.yml", false);
	    }
		
		cbTime = new HashMap<String,Integer>();
		cbTask= new HashMap<String,BukkitRunnable>();
		chunk = new HashMap<String,Chunk>();
		
		getCommand(command1.cmd1).setExecutor(command1);
		
		Bukkit.getPluginManager().registerEvents(new GLTShopListener(this), this);
		Bukkit.getPluginManager().registerEvents(new BlastShovelListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ItemCrafterListener(this), this);
		Bukkit.getPluginManager().registerEvents(new HarvesterHoeListener(this), this);
		Bukkit.getPluginManager().registerEvents(new LightningWandListener(this), this);
		Bukkit.getPluginManager().registerEvents(new TrayPickaxeListener(this), this);
		Bukkit.getPluginManager().registerEvents(new TrenchPickaxeListener(this), this);
		Bukkit.getPluginManager().registerEvents(new SandWandListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ChunkBusterListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ChunkBusterGUIListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ChunkBusterWFListener(this), this);
	}
	
	private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }
}
