package me.nullchips.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.PlayerInventory;

import me.nullchips.core.Core;
import me.nullchips.core.utils.ChatUtils;

public class PlayerLogin implements Listener {

	@EventHandler
	public void onPlayerLogin(final PlayerLoginEvent e) {

		final Player p = e.getPlayer();
		final PlayerInventory pi = e.getPlayer().getInventory();

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable() {
			public void run() {
				ChatUtils.broadcast(e.getPlayer().getName() + " has joined the server.");
				p.sendMessage("");
				p.setGameMode(GameMode.SURVIVAL);
				pi.clear();
				
				if(!e.getPlayer().hasPlayedBefore()) {
					ChatUtils.broadcast(e.getPlayer().getName() + " has joined the server for the first time!");
					for(Player p : Bukkit.getOnlinePlayers()) {

						p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 1);
					}
				}
			}
		}, 1);
	}
}
