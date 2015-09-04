package me.nullchips.core.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class List implements CommandExecutor {
	
	ArrayList<String> onlinePlayers = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("list")) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				onlinePlayers.add(p.getName());
				}
			
			Player p = (Player) sender;
			ChatUtils.message(p, "Online players: " + ChatColor.AQUA + onlinePlayers.toString());
			onlinePlayers.clear();
		}
		return true; 
	}

}
