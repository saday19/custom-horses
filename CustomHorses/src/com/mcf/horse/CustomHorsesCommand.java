package com.mcf.horse;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class CustomHorsesCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("customhorses")) {
			
			if(sender.hasPermission("customhorses.admin")) {
				
				if(args.length == 0) {
					
					sender.sendMessage("§cIncorrect Usage! Try: §7§n/customhorses help§7 for more information.");
					return false;
					
				}
				
				if(args.length > 0) {
					
					if(args[0].equalsIgnoreCase("help")) {
						
						sender.sendMessage("");
						sender.sendMessage("§a§lCustom Horses Commands:");
						sender.sendMessage("");
						sender.sendMessage("§a - /customhorses setitem <Black, Zombie, Skeleton>§7 - Sets the saddle for the respective horse.");
						sender.sendMessage("§a - /customhorses giveitem <Black, Zombie, Skeleton>§7 - Gives the sender the saddle for the horse.");
						sender.sendMessage("§a - /customhorses reload§7 - Reloads the items.");
						sender.sendMessage("");
						
					} else if(args[0].equalsIgnoreCase("reload")) {
						
						Items.save();
						Items.load();
						
						sender.sendMessage("§a§lCustomHorses§a has been successfully reloaded.");
						
					} else if(args[0].equalsIgnoreCase("setitem")) {
						
						if(sender instanceof Player) {
							
							Player player = (Player) sender;
							
							if(args.length > 1) {
								
								ItemStack item = player.getInventory().getItemInMainHand();
								
								if(item == null) {return false;}
								if(item.getType() == Material.AIR) {return false;}
								
								if(args[1].equalsIgnoreCase("black")) {
									Items.setBlackHorseSaddle(item);
								} else if(args[1].equalsIgnoreCase("zombie")) {
									Items.setZombieHorseSaddle(item);
								} else if(args[1].equalsIgnoreCase("skeleton")) {
									Items.setSkeletonHorseSaddle(item);
								} else {
									player.sendMessage("§cIncorrect Usage! Try: §7§n/customhorses giveitem <Black, Zombie, Skeleton>§7.");
									return false;
								}
								player.sendMessage("§aSaddle set!");
								return true;
								
							} else {
								
								player.sendMessage("§cIncorrect Usage! Try: §7§n/customhorses setitem <Black, Zombie, Skeleton>§7.");
								return false;
								
							}
							
						} else {
							sender.sendMessage(ChatColor.RED + "Error! You must be a player to do this!");
							return false;
						}
						
					}  else if(args[0].equalsIgnoreCase("giveitem")) {
						
						if(sender instanceof Player) {
							
							Player player = (Player) sender;
							
							if(args.length > 1) {
								
								ItemStack toGive = null;
								
								if(args[1].equalsIgnoreCase("black")) {
									toGive = Items.getBlackHorseSaddle();
								} else if(args[1].equalsIgnoreCase("zombie")) {
									toGive = Items.getZombieHorseSaddle();
								} else if(args[1].equalsIgnoreCase("skeleton")) {
									toGive = Items.getSkeletonHorseSaddle();
								} else {
									player.sendMessage("§cIncorrect Usage! Try: §7§n/customhorses giveitem <Black, Zombie, Skeleton>§7.");
									return false;
								}
								
								if(toGive == null) {return false;}
								if(toGive.getType() == Material.AIR) {return false;}
								
								player.getInventory().addItem(toGive);
								return true;
								
							} else {
								
								player.sendMessage("§cIncorrect Usage! Try: §7§n/customhorses giveitem <Black, Zombie, Skeleton>§7.");
								return false;
								
							}
							
						} else {
							sender.sendMessage(ChatColor.RED + "Error! You must be a player to do this!");
							return false;
						}
						
					}
					
				}
				
				
			} else {
				
				sender.sendMessage(ChatColor.RED + "Error! You do not have permission to do this!");
				
			}
			
		}
		
		return false;
	}

}
