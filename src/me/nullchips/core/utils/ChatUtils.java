package me.nullchips.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
	
	public static void broadcast(String message) {
		
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_AQUA + "ServerName" + ChatColor.DARK_RED + "]" +  ChatColor.GOLD + " " + message);
		
	}
	
	public static void noPermission(Player player) {
		player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
	}
	
	public static void message(Player p, String message) {
		p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_AQUA + "ServerName" + ChatColor.DARK_RED + "]" +  ChatColor.GOLD + " " + message);
	}
	
	public static void helpop(Player p, Player sendto, String message) {
		p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_AQUA + "ServerName" + ChatColor.DARK_RED + "]" +  ChatColor.GOLD + " You receieved a helpop from: " + ChatColor.AQUA + p.getName());
		p.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_AQUA + "ServerName" + ChatColor.DARK_RED + "]" +  ChatColor.GRAY + message);
	}
	
	public static void chatMessage(Player p, String message) {
		Bukkit.getServer().broadcastMessage(ChatColor.AQUA+ p.getName() + ": " + ChatColor.GRAY + message);
	}

}
