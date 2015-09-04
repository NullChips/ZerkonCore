package me.nullchips.core.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class Vanish implements CommandExecutor {

	public static ArrayList<Player> vanished = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {



		if (cmd.getName().equalsIgnoreCase("vanish")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
				return true;
			}

			Player p = (Player) sender;

			if(!p.hasPermission("core.vanish")) {
				ChatUtils.noPermission(p);
				return false;
			}

				if (!vanished.contains(p)) {
					for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
						if(!pl.hasPermission("core.vanish.see")) {
							pl.hidePlayer(p);
						}
					}
					vanished.add(p);
					p.sendMessage(ChatColor.GREEN + "You have been vanished!");
					return true;
				}
				else {
					for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
						pl.showPlayer(p);
					}
					vanished.remove(p);
					p.sendMessage(ChatColor.GREEN + "You have been unvanished!");
					return true;
				}
		}
		return true;
	}


}

