package me.nullchips.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.nullchips.core.commands.Vanish;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage("");
		for (Player p : Vanish.vanished) {
			if(!e.getPlayer().hasPermission("core.vanish.see")) {
				e.getPlayer().hidePlayer(p);
			}
		}
	}
}
