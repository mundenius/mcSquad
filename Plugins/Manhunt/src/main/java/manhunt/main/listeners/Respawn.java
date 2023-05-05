package manhunt.main.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import manhunt.main.Main;

public class Respawn implements Listener{

	private Main plugin; 
	
	public Respawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	/**@category Metodo Listener 
	 * @param onHunterDeath
	 * Cuando un cazador respawnea luego de morir, se le devuelve una brujula.*/
	public void onHunterDeath(PlayerRespawnEvent pre) {
		Player jugador = pre.getPlayer();
		if(plugin.getHuntersId().contains(jugador.getUniqueId())) {
			jugador.getInventory().addItem(new ItemStack(Material.COMPASS));
		}
	}
}
