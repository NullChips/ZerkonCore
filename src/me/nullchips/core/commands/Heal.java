package me.nullchips.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class Heal implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
			return false;
		}

		Player p = (Player) sender;

		if(!p.hasPermission("core.heal")) {
			ChatUtils.noPermission(p);
			return false;
		}

		if(args.length==0) {
			p.setHealth(20);
			p.setFoodLevel(20);
			ChatUtils.message(p, "You have been healed.");
			return true;
		}
		
		@SuppressWarnings("deprecation")
		Player target = Bukkit.getServer().getPlayer(args[0]); 
		
		if(target == null) {
			p.sendMessage(ChatColor.RED + "That player is not online.");
			return false;
		}
		
		target.setHealth(20);
		target.setFoodLevel(20);
		ChatUtils.message(target, "You have been healed by: " + ChatColor.AQUA + p.getName() + ChatColor.GOLD + ".");
		ChatUtils.message(p, "You have healed: " + ChatColor.AQUA + target.getName() + ChatColor.GOLD + ".");
		
		return true;
	}

}
