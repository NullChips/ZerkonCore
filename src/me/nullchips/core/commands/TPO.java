package me.nullchips.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class TPO implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(cmd.getName().equalsIgnoreCase("tpo")) {

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
				p.teleport(target.getLocation());
				ChatUtils.message(p, "You have teleported to: " + ChatColor.AQUA + target.getName() + ChatColor.GOLD + ".");
				return true;
			}

			if(args.length == 2) {
				@SuppressWarnings("deprecation")
				Player target1 = Bukkit.getServer().getPlayer(args[0]);
				if(target1 == null) {
					p.sendMessage(ChatColor.RED + "The first player you specified is not online.");
					return false;
				}
				@SuppressWarnings("deprecation")
				Player target2 = Bukkit.getServer().getPlayer(args[1]);
				if(target2 == null) {
					p.sendMessage(ChatColor.RED + "The second player you specified is not online.");
					return false;
				}
				target1.teleport(target2.getLocation());
				if(p.getName().equals(target1.getName())) {
					ChatUtils.message(p, "You have teleported to: " + ChatColor.AQUA + target2.getName() + ChatColor.GOLD + ".");
					return true;
				}
				if(p.getName().equals(target2.getName())) {
					ChatUtils.message(p, "You have teleported to: " + ChatColor.AQUA + target2.getName() + ChatColor.GOLD + ".");
					return true;
				}
				ChatUtils.message(p, "You have teleported: " + ChatColor.AQUA + target1.getName() + ChatColor.GOLD + " to: " + ChatColor.AQUA + target2.getName() + ChatColor.GOLD + ".");
				return true;
			}

			p.sendMessage(ChatColor.RED + "Too many arguments specified!");

			return false;
		}
		return false;
	}

}
