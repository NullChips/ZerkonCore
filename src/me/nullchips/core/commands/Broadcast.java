package me.nullchips.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class Broadcast implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("broadcast")) {
			Player p = (Player) sender;
			if(!p.hasPermission("core.broadcast")) {
				ChatUtils.noPermission(p);
				return true;
			}
			
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Please specify something to broadcast.");
				return false;
			}
			
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < args.length; i++ ) {
				str.append(args[i] + " ");
			}
			String broadcast = str.toString();
			ChatUtils.broadcast(broadcast);

		}
		
		return true;
		
	}

}
