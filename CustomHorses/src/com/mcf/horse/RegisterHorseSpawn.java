package com.mcf.horse;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class RegisterHorseSpawn implements Listener {
	
	private static ArrayList<Player> spawned_horses = new ArrayList<Player>();
	private int[] axis = {-1, 0, 1};
	
	private ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onDropHorse(PlayerDropItemEvent e) {
		if(spawned_horses.contains(e.getPlayer())) {
			if(e.getItemDrop().getItemStack().getType() == Material.SADDLE) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "You cannot drop this item right now!");
			}
		}
	}
	
	@EventHandler
	public void registerSpawnHorse(PlayerInteractEvent e) {
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
			
			if(item == null) {return;}
			if(item.getType() == Material.AIR) {return;}
			
			if(item.equals(Items.getBlackHorseSaddle())) {
				if(spawned_horses.contains(e.getPlayer())) {
					
					e.getPlayer().sendMessage(ChatColor.RED + "You are unable to spawn a horse right now!");
					return;
					
				}
				
				boolean canspawn = true;
				Location location = e.getPlayer().getEyeLocation();
				
				for(int x : axis) {
					for(int z : axis) {
						Location block_location = new Location(location.getWorld(), location.getX() + x, location.getY(), location.getZ() + z);
						Block block = block_location.getWorld().getBlockAt(block_location);
						if(block.getType() != Material.AIR) {
							canspawn = false;
							break;
						}
					}
					if(!canspawn) break;
				}
				
				if(!canspawn) {
					if(!cooldown.contains(e.getPlayer())) {
						e.getPlayer().sendMessage(ChatColor.RED + "There is not enough room to spawn your horse!");
						handleCooldown(e.getPlayer());
					}
					return;
				}
				
				Horses.spawnBlack(e.getPlayer());
				spawned_horses.add(e.getPlayer());
			} else if(item.equals(Items.getZombieHorseSaddle())) {
				if(spawned_horses.contains(e.getPlayer())) {
					
					e.getPlayer().sendMessage(ChatColor.RED + "You are unable to spawn a horse right now!");
					return;
					
				}
				
				boolean canspawn = true;
				Location location = e.getPlayer().getEyeLocation();
				
				for(int x : axis) {
					for(int z : axis) {
						Location block_location = new Location(location.getWorld(), location.getX() + x, location.getY(), location.getZ() + z);
						Block block = block_location.getWorld().getBlockAt(block_location);
						if(block.getType() != Material.AIR) {
							canspawn = false;
							break;
						}
					}
					if(!canspawn) break;
				}
				
				if(!canspawn) {
					if(!cooldown.contains(e.getPlayer())) {
						e.getPlayer().sendMessage(ChatColor.RED + "There is not enough room to spawn your horse!");
						handleCooldown(e.getPlayer());
					}
					return;
				}
				
				Horses.spawnZombie(e.getPlayer());
				spawned_horses.add(e.getPlayer());
			} else if(item.equals(Items.getSkeletonHorseSaddle())) {
				if(spawned_horses.contains(e.getPlayer())) {
					
					e.getPlayer().sendMessage(ChatColor.RED + "You are unable to spawn a horse right now!");
					return;
					
				}
				
				boolean canspawn = true;
				Location location = e.getPlayer().getEyeLocation();
				
				for(int x : axis) {
					for(int z : axis) {
						Location block_location = new Location(location.getWorld(), location.getX() + x, location.getY(), location.getZ() + z);
						Block block = block_location.getWorld().getBlockAt(block_location);
						if(block.getType() != Material.AIR) {
							canspawn = false;
							break;
						}
					}
					if(!canspawn) break;
				}
				
				if(!canspawn) {
					if(!cooldown.contains(e.getPlayer())) {
						e.getPlayer().sendMessage(ChatColor.RED + "There is not enough room to spawn your horse!");
						handleCooldown(e.getPlayer());
					}
					return;
				}
				
				Horses.spawnSkeleton(e.getPlayer());
				spawned_horses.add(e.getPlayer());
			}
			
		}
		
	}

	public static ArrayList<Player> getRidingPlayers() {
		return spawned_horses;
	}
	
	public static void removeRidingPlayer(Player player) {
		if(spawned_horses.contains(player)) {
			spawned_horses.remove(player);
		}
	}
	
	private void handleCooldown(Player player) {
		cooldown.add(player);
		new BukkitRunnable() {
			public void run() {
				cooldown.remove(player);
			}
		}.runTaskLater(HorseSaddles.getInstance(), 40);
	}
	
}
