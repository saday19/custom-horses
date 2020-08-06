package com.mcf.horse;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RegisterDenyRemoveSaddle implements Listener {

	@EventHandler
	public void registerClickHorseInventory(InventoryClickEvent e) {
		
		if(e.getInventory().getName().contains("Horse")) {
			
			if(e.getCurrentItem() == null) return;
			if(e.getCurrentItem().getType() == Material.AIR) return;
			
			if(!(e.getClickedInventory().getHolder() instanceof Player)) {
				e.setCancelled(true);
			}
		}
		
	}
	
}
