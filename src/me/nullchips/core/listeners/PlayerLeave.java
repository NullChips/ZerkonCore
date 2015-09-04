package me.nullchips.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.nullchips.core.commands.Vanish;

public class PlayerLeave implements Listener {
	
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
           Vanish.vanished.remove(e.getPlayer());
    }

}
