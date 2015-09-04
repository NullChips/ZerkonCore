package me.nullchips.core;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.nullchips.core.commands.Broadcast;
import me.nullchips.core.commands.Feed;
import me.nullchips.core.commands.GMC;
import me.nullchips.core.commands.GMS;
import me.nullchips.core.commands.Heal;
import me.nullchips.core.commands.HelpOP;
import me.nullchips.core.commands.List;
import me.nullchips.core.commands.Mute;
import me.nullchips.core.commands.Speed;
import me.nullchips.core.commands.TPHere;
import me.nullchips.core.commands.TPO;
import me.nullchips.core.commands.Teleport;
import me.nullchips.core.commands.Unmute;
import me.nullchips.core.commands.Vanish;
import me.nullchips.core.listeners.ASyncPlayerChat;
import me.nullchips.core.listeners.BlockIgnite;
import me.nullchips.core.listeners.PlayerJoin;
import me.nullchips.core.listeners.PlayerLogin;

public class Core extends JavaPlugin {
	
	private static Plugin pl;
	
	public void onEnable() {
		pl = this;
		
		//LISTENERS
		registerEvents(this, new PlayerLogin());
		registerEvents(this, new PlayerJoin());
		registerEvents(this, new ASyncPlayerChat());
		registerEvents(this, new BlockIgnite());
		
		//COMMANDS
		getCommand("heal").setExecutor(new Heal());
		getCommand("teleport").setExecutor(new Teleport());
		getCommand("tphere").setExecutor(new TPHere());
		getCommand("tpo").setExecutor(new TPO());
		getCommand("feed").setExecutor(new Feed());
		getCommand("helpop").setExecutor(new HelpOP());
		getCommand("list").setExecutor(new List());
		getCommand("mute").setExecutor(new Mute());
		getCommand("unmute").setExecutor(new Unmute());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("gms").setExecutor(new GMS());
		getCommand("gmc").setExecutor(new GMC());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("speed").setExecutor(new Speed());
	}
	
	public void onDisable() {
		pl = null;
	}
	
	public static Plugin getPlugin() {
		return pl;
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
	
	public static ArrayList<String> mutedPlayers = new ArrayList<String>();
	
	public static void addMutedPlayer(String p) {
		mutedPlayers.add(p);
	}
	
	public static void removeMutedPlayer(String p) {
		mutedPlayers.remove(p);
	}

}

//TODO Social spy for messages.

//TODO Change name of plugin in plugin.yml file.
