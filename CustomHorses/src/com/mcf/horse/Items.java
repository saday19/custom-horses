package com.mcf.horse;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class Items {

	private static ItemStack blackSaddle = new ItemStack(Material.SADDLE);
	private static ItemStack zombieSaddle = new ItemStack(Material.SADDLE);
	private static ItemStack skeletonSaddle = new ItemStack(Material.SADDLE);
	
	public static void load() {
		
		File f = new File("plugins/CustomHorses/saddles.yml");
		
		if(!f.exists()) {
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(f);
			
			if(config.isSet("black-horse")) {
				blackSaddle = config.getItemStack("black-horse");
			}
			
			if(config.isSet("skeleton-horse")){
				skeletonSaddle = config.getItemStack("skeleton-horse");
			}
			
			if(config.isSet("zombie-horse")) {
				zombieSaddle = config.getItemStack("zombie-horse");
			}
			
		}
		
	}
	
	public static void save() {
		
		File f = new File("plugins/CustomHorses/saddles.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(f);
		
		config.set("black-horse", blackSaddle);
		config.set("skeleton-horse", skeletonSaddle);
		config.set("zombie-horse", zombieSaddle);
		
		try {
			config.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ItemStack getBlackHorseSaddle() {
		return blackSaddle;
	}
	
	public static ItemStack getZombieHorseSaddle() {
		return zombieSaddle;
	}
	
	public static ItemStack getSkeletonHorseSaddle() {
		return skeletonSaddle;
	}
	
	public static void setBlackHorseSaddle(ItemStack newSaddle) {
		blackSaddle = newSaddle;
	}
	
	public static void setZombieHorseSaddle(ItemStack newSaddle) {
		zombieSaddle = newSaddle;
	}
	
	public static void setSkeletonHorseSaddle(ItemStack newSaddle) {
		skeletonSaddle = newSaddle;
	}
}
