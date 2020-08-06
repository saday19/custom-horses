package com.mcf.horse;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Player;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.inventory.ItemStack;

public class Horses {

	@SuppressWarnings("deprecation")
	public static void spawnBlack(Player player) {

		Horse newHorse = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
		newHorse.setAdult();
		newHorse.setColor(Color.BLACK);
		newHorse.setStyle(Style.NONE);
		newHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.3);
		newHorse.getAttribute(Attribute.HORSE_JUMP_STRENGTH).setBaseValue(0.9);
		newHorse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		newHorse.setPassenger(player);
		newHorse.setMaxHealth(20);
		newHorse.setHealth(20);
		newHorse.setOwner(player);
		newHorse.setCustomName("§a" + player.getName() + "'s Horse");

	}

	@SuppressWarnings("deprecation")
	public static void spawnZombie(Player player) {

		ZombieHorse newHorse = (ZombieHorse) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE_HORSE);
		newHorse.setAdult();
		newHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4);
		newHorse.getAttribute(Attribute.HORSE_JUMP_STRENGTH).setBaseValue(0.9);
		newHorse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		newHorse.setPassenger(player);
		newHorse.setMaxHealth(20);
		newHorse.setHealth(20);
		newHorse.setOwner(player);
		newHorse.setCustomName("§a" + player.getName() + "'s Zombie Horse");

	}

	@SuppressWarnings("deprecation")
	public static void spawnSkeleton(Player player) {

		SkeletonHorse newHorse = (SkeletonHorse) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON_HORSE);
		newHorse.setAdult();
		newHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4);
		newHorse.getAttribute(Attribute.HORSE_JUMP_STRENGTH).setBaseValue(0.9);
		newHorse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		newHorse.setPassenger(player);
		newHorse.setMaxHealth(20);
		newHorse.setHealth(20);
		newHorse.setOwner(player);
		newHorse.setCustomName("§a" + player.getName() + "'s Skeleton Horse");

	}

}
