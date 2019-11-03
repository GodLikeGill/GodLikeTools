package me.jatinsingh.glt.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jatinsingh.glt.Main;

public class GLT implements CommandExecutor {
	
	private Main plugin;
	private GLT1 glt1;
	private GLT2 glt2;
	
	public GLT(Main plugin) {
		this.plugin = plugin;
		glt1 = new GLT1(this.plugin);
		glt2 = new GLT2(this.plugin);
	}
	
	public String cmd1 = "glt";
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase(cmd1)) {
				
				if(args.length == 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
							"&9&m------------&b GodLikeTools &9&m------------\n"
							+ "&eGodLike tools plugin by Jatinsingh. /glt help\n"
							+ "&9&m------------------------------------"));
				}
				
				if(args.length == 1) {
					glt1.OneArgCmd(p,args[0]);
				}
				
				if(args.length == 2) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if(target == null) {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Could not find player!");
						return true;
					}
					glt2.TwoArgCmd(p,target,args[0],args[1]);
				}
			}
		}
		return true;
	}
}