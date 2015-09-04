package me.nullchips.core.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.nullchips.core.Core;
import me.nullchips.core.utils.ChatUtils;

public class ASyncPlayerChat implements Listener {

	@EventHandler
	public void onASyncPlayerChatEvent(AsyncPlayerChatEvent e) {
		if(Core.mutedPlayers.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
			Player p = e.getPlayer();
			ChatUtils.message(p, ChatColor.RED + "You are muted!");
		}
		else {
			e.setCancelled(true);
			String message = e.getMessage();
			Player p = e.getPlayer();
			ChatUtils.chatMessage(p, message);
		}
	}
}
