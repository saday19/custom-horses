package com.mcf.horse;

import org.bukkit.plugin.java.JavaPlugin;

public class HorseSaddles extends JavaPlugin {

	private static HorseSaddles plugin;
	
	public void onEnable() {
		plugin = this;
		//load items
		Items.load();
		//register cmd
		getCommand("customhorses").setExecutor(new CustomHorsesCommand());
		//register click
		getServer().getPluginManager().registerEvents(new RegisterHorseSpawn(), this);
		//register get off horse
		getServer().getPluginManager().registerEvents(new RegisterDismountHorse(this), this);
		//deny horse damage
		getServer().getPluginManager().registerEvents(new RegisterDenyHorseDamage(), this);
		//clear drops on death
		getServer().getPluginManager().registerEvents(new RegisterDenyHorseDrops(), this);
		//deny remove saddle from horse inv
		getServer().getPluginManager().registerEvents(new RegisterDenyRemoveSaddle(), this);
		
	}
	
	public void onDisable() {
		
		//save items
		Items.save();
		
	}
	
	public static HorseSaddles getInstance() {
		return plugin;
	}
	
}
