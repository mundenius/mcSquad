/**@author mundenius */
package manhunt.main.listeners;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import manhunt.main.Main;

public class CompassClick implements Listener {

	private Main plugin;

	public CompassClick(Main plugin) {
		this.plugin = plugin;
	}

	/**@category Metodo Listener
	 * @param onCompassClick
	 * Metodo que hace que la brujula apunte a un jugador distinto cada vez que se hace click */
	@EventHandler
	public void onCompassClick(PlayerInteractEvent pie) {
		 if (plugin.getHuntersId().contains(pie.getPlayer().getUniqueId())) {
		        Player hunter = pie.getPlayer();
		        ItemStack item = pie.getItem();
		        Action accion = pie.getAction();

		        if (item != null && item.getType() == Material.COMPASS && (accion == Action.RIGHT_CLICK_AIR || accion == Action.RIGHT_CLICK_BLOCK)) {
		            Player jugador = toggleSurvivors();
		            if (jugador != null) {
		            	if(hunter.getWorld().getEnvironment() == World.Environment.NETHER) {
		            		if (plugin.getConfig().getBoolean("nethertracking", false)) {
		            			if (jugador.getWorld().getEnvironment() == World.Environment.NETHER && hunter.getWorld().getEnvironment() == World.Environment.NETHER) {
		            				if(item.getType() == Material.COMPASS && item.getItemMeta().hasEnchant(Enchantment.VANISHING_CURSE)) {
		            					item.removeEnchantment(Enchantment.VANISHING_CURSE);
		            				}
		            				CompassMeta meta = (CompassMeta) item.getItemMeta();
		            				if (meta == null) {
		            					meta = (CompassMeta) (new ItemStack(Material.COMPASS).getItemMeta());
		            				}
		            				
		            				meta.setLodestone(jugador.getLocation());
		            				meta.setLodestoneTracked(false);
		            				item.setItemMeta(meta);
		            				hunter.sendMessage("Trackeando a " + ChatColor.RED + ChatColor.BOLD + jugador.getName());
		            			} else {
		            				hunter.sendMessage("No se puede trackear a un jugador si no estan ambos en el Nether");
		            			}
		            		}else {
		            			hunter.sendMessage("NetherTracking esta desactivado");
		            		}
		                } else if (hunter.getWorld().getEnvironment() == World.Environment.NORMAL) {
		                	if(item.getType() == Material.COMPASS && item.getItemMeta().hasEnchant(Enchantment.VANISHING_CURSE)) {
            					item.removeEnchantment(Enchantment.VANISHING_CURSE);
            				}
		                	CompassMeta meta = (CompassMeta) item.getItemMeta();
		                    if (meta == null) {
		                        meta = (CompassMeta) (new ItemStack(Material.COMPASS).getItemMeta());
		                    }

		                    meta.setLodestone(jugador.getLocation());
		                    meta.setLodestoneTracked(false);
		                    item.setItemMeta(meta);
		                    hunter.sendMessage("Trackeando a " + ChatColor.AQUA + ChatColor.BOLD + jugador.getName());
		                }
		                else {
			                hunter.sendMessage("No puedes trackear a jugadores en el END");

		                }
		            } else {
		                hunter.sendMessage("No se han encontrado jugadores para trackear en el mundo");
		            }
		        }
		 }
		}
	/**@category Metodo Auxiliar
	 * @param toggleSurvivors
	 * Metodo que genera una lista con todos los jugadores en survival y que no sean cazadores
	 * Luego verifica si la lista esta vacia, en caso de que lo este, retorna null
	 * en caso de que si hayan jugadores, 
	 *  */
	int currentSurvivorIndex = 0;
	private Player toggleSurvivors() {

		/**@param Lista de jugadores en survival
		 * Primero agrega a todos los jugadores que estan en el OverWorld */
		List<Player> survivalPlayers = new ArrayList<>();
	    for (Player jugador : (Bukkit.getServer().getWorld("world").getPlayers())) {
	        if (jugador.getGameMode() == GameMode.SURVIVAL && !plugin.getHuntersId().contains(jugador.getUniqueId())) {
	            survivalPlayers.add(jugador);
	        }
	    }
	    World netherWorld = Bukkit.getServer().getWorld("world_nether");
	    if (netherWorld != null) {
	        for (Player jugador : netherWorld.getPlayers()) {
	            if (jugador.getGameMode() == GameMode.SURVIVAL && !plugin.getHuntersId().contains(jugador.getUniqueId())) {
	                survivalPlayers.add(jugador);
	            }
	        }
	    }
	    if (survivalPlayers.isEmpty()) {
	        return null;
	    }


        /**@param current index = se le suma 1 al resultado anterior y se divide por el tamaño de los jugadores en survival, de esta forma siempre nos saldra uno distinto
         * al usar %, nos aseguramos de que el resultado sea entre 0 y entre el tamaño de la lista survivalPlayers creada al comienzo*/
        System.out.println(currentSurvivorIndex);
	    currentSurvivorIndex = (currentSurvivorIndex + 1) % survivalPlayers.size();
        System.out.println(currentSurvivorIndex);
        Player nextSurvivor = survivalPlayers.get(currentSurvivorIndex);
        System.out.println(nextSurvivor);
	    /**@param return survival player = se retorna el index resultante de la logica anterior para ser usado en el metodo onCompassClick */
        return nextSurvivor;
	}
	
//	/**@category Metodo Auxiliar
//	 * @param toggleNetherSurvivor
//	 * Genera una lista con todos los jugadores en modo supervivencia que se encuentren en el Nether
//	 * */
//	
//	private Player toggleNetherSurvivor(Player hunter) {
//		List<Player> netherSurvival = new ArrayList<>();
//	    World netherWorld = Bukkit.getServer().getWorld("world_nether");
//	    if (netherWorld != null) {
//	        for (Player jugador : netherWorld.getPlayers()) {
//	            if (jugador.getGameMode() == GameMode.SURVIVAL && !plugin.getHuntersId().contains(jugador.getUniqueId())) {
//	                netherSurvival.add(jugador);
//	            }
//	        }
//	    }
//	    if (netherSurvival.isEmpty()) {
//	        return null;
//	    }
//
//	    /**@param current index ARRAYLIST: se crea un arraylist con el indice de los cazadores; de esta forma nos aseguramos de que al menos sea 0
//	     *  */
//	    int currentIndex = new ArrayList<>(plugin.getHuntersId()).indexOf(hunter.getUniqueId());
//	    /**@param current index = se le suma 1 al resultado anterior y se divide por el tamaño de los jugadores en survival, de esta forma siempre nos saldra uno distinto
//	     * al usar %, nos aseguramos de que el resultado sea entre 0 y entre el tamaño de la lista survivalPlayers creada al comienzo*/
//	    currentIndex = (currentIndex + 1) % netherSurvival.size();
//	    /**@param return survival player = se retorna el index resultante de la logica anterior para ser usado en el metodo onCompassClick */
//	    return netherSurvival.get(currentIndex);
//	}
//	
	}
