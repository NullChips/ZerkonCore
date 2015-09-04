package me.nullchips.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class ClearChat implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
			return false;
		}
		
		Player p = (Player) sender;
		
		if(!p.hasPermission("core.clearchat")) {
			ChatUtils.noPermission(p);
			return false;
		}
		
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		ChatUtils.message(p, "Chat cleared.");
		
		return false;
	}

}
