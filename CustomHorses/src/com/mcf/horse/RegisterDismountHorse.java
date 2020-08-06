package com.mcf.horse;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class RegisterDismountHorse implements Listener {

	private HorseSaddles plugin;
	
	public RegisterDismountHorse(HorseSaddles plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onDismount(VehicleExitEvent e) {
		
		if(e.getVehicle() instanceof Horse || e.getVehicle() instanceof ZombieHorse || e.getVehicle() instanceof SkeletonHorse) {
			Player player = (Player) e.getExited();
			if(e.getVehicle() instanceof Horse) {
				Horse horse = (Horse) e.getVehicle();
				if(!horse.getCustomName().contains(player.getName())) {
					return;
				}
			} else if(e.getVehicle() instanceof ZombieHorse) {
				ZombieHorse horse = (ZombieHorse) e.getVehicle();
				if(!horse.getCustomName().contains(player.getName())) {
					return;
				}
			} else if(e.getVehicle() instanceof SkeletonHorse) {
				SkeletonHorse horse = (SkeletonHorse) e.getVehicle();
				if(!horse.getCustomName().contains(player.getName())) {
					return;
				}
			}
			
			e.getVehicle().remove();
			
			if(e.getExited() instanceof Player) {
				new BukkitRunnable() {
					public void run() {
						RegisterHorseSpawn.removeRidingPlayer((Player) e.getExited());
					}
				}.runTaskLater(plugin, 40);
			}
			
		}
		
	}
	
}
