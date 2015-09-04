package me.nullchips.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class BlockIgnite implements Listener {
	
	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent e) {
		if (e.getCause().equals((Object)BlockIgniteEvent.IgniteCause.SPREAD) || e.getCause().equals((Object)BlockIgniteEvent.IgniteCause.LAVA)) {
            e.setCancelled(true);
        }
	}

}
