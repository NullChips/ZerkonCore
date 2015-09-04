package me.nullchips.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.core.utils.ChatUtils;

public class Speed implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
			return false;
		}

		Player p = (Player) sender;

		if(!p.hasPermission("core.speed")) {
			ChatUtils.noPermission(p);
			return false;
		}

		if(args.length==0) {
			p.sendMessage(ChatColor.RED + "Please specify a speed to fly.");
			return false;
		}

		float speed = Float.parseFloat(args[0]);

		if(speed > 10) {
			p.setFlySpeed(1);
			ChatUtils.message(p, "Flying speed set to 10.");
			return true;
		}

		else{
			p.setFlySpeed(speed/10);
			ChatUtils.message(p, "Flying speed set to " + speed);
			return true;
		}
	}
}
