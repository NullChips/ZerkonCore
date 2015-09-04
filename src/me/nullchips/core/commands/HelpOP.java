package me.nullchips.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class HelpOP implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("helpop")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("The console cannot use this command.");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				ChatUtils.message(p, "Please specify something that you would like help with.");
				return false;
			}
			
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < args.length; i++ ) {
				str.append(args[i] + " ");
			}
			String message = str.toString();
			
			for(Player players : Bukkit.getServer().getOnlinePlayers()) {
				if(p.hasPermission("core.helpop")) {
					ChatUtils.helpop(p, players, message);
				}
			}
		}
		
		return false;
	}

}
