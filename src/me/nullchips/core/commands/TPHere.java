package me.nullchips.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class TPHere implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("The console cannot use this command.");
			return false;
		}

		Player p = (Player) sender;

		if(!p.hasPermission("core.teleport")) {
			ChatUtils.noPermission(p);
			return false;
		}
		
		if(args.length == 0) {
			p.sendMessage(ChatColor.RED + "Please specify a player.");
			return false;
		}
		
		if(args.length == 1) {
			@SuppressWarnings("deprecation")
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(target == null) {
				p.sendMessage(ChatColor.RED + "That player is not online.");
				return false;
			}
			target.teleport(p.getLocation());
			ChatUtils.message(p, "You have teleported to: " + ChatColor.AQUA + target.getName() + ChatColor.GOLD + ".");
			ChatUtils.message(target, ChatColor.AQUA + p.getName() + ChatColor.GOLD + " has teleported to you.");
			return true;
		}

		p.sendMessage(ChatColor.RED + "Too many arguments specified!");
		
		return false;
	}

}
