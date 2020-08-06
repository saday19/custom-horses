package com.mcf.horse;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RegisterDenyHorseDamage implements Listener {

	@EventHandler
	public void registerHorseDamage(EntityDamageByEntityEvent e) {

		if (e.getDamager() instanceof Player) {
			if (e.getEntity() instanceof Horse || e.getEntity() instanceof ZombieHorse || e.getEntity() instanceof SkeletonHorse) {

				e.setCancelled(true);

			}
		} else if (e.getDamager() instanceof Projectile && ((Projectile) e.getDamager()).getShooter() instanceof Player) {
			if (e.getEntity() instanceof Horse || e.getEntity() instanceof ZombieHorse || e.getEntity() instanceof SkeletonHorse) {

				e.setCancelled(true);

			}
		}


	}

}
