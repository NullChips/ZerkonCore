package me.nullchips.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.Core;

public class Unmute implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("unmute")) {
			if(args.length==0) {
				sender.sendMessage(ChatColor.RED + "Please specify a player to mute.");
				return false;
			}
			
			if(!sender.hasPermission("core.mute")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
				return false;
			}
			@SuppressWarnings("deprecation")
			Player target = Bukkit.getServer().getPlayer(args[0]);

			if(target == null) {
				sender.sendMessage(ChatColor.RED + "That player is not online!");
				return false;
			}
			
			if(!Core.mutedPlayers.contains(target.getName())) {
				sender.sendMessage(ChatColor.RED + target.getName() + " is not muted.");
				return true;
			}
			
			Core.removeMutedPlayer(target.getName());
			sender.sendMessage(ChatColor.GREEN + target.getName() + " has been unmuted.");
			target.sendMessage(ChatColor.GREEN + "You have been unmuted.");
			return true;
			
		}
		
		return false;
	}

}
