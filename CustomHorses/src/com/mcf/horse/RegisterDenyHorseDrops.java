package com.mcf.horse;

import org.bukkit.entity.Horse;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class RegisterDenyHorseDrops implements Listener {

	@EventHandler
	public void denyDrops(EntityDeathEvent e) {
		
		if(e.getEntity() instanceof Horse || e.getEntity() instanceof ZombieHorse || e.getEntity() instanceof SkeletonHorse) {
			e.getDrops().clear();
		}
		
	}
	
}
