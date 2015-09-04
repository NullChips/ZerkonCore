package me.nullchips.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.nullchips.core.Core;

public class Mute implements CommandExecutor, Listener{
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("mute")) {
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
				sender.sendMessage(ChatColor.RED + "That player is not online.");
				return false;
			}
			
			if(Core.mutedPlayers.contains(target.getName())) {
				sender.sendMessage(ChatColor.RED + target.getName() + " is already muted.");
				return true;
			}
			
			Core.addMutedPlayer(target.getName());
			sender.sendMessage(ChatColor.GREEN + target.getName() + " has been muted.");
			target.sendMessage(ChatColor.RED + "You have been muted!");
			return true;
			
		}
		return false;
	}
}
