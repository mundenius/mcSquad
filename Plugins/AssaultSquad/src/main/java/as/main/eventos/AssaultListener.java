package as.main.eventos;

import java.awt.Event;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import as.main.Main;

public class AssaultListener implements Listener {

	private Main plugin;
	
	public AssaultListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void trasCombate(PlayerDeathEvent pde) {
		Player killer = pde.getEntity().getKiller();
		if(killer != null && killer != pde.getEntity()) {
			UUID killerId = killer.getUniqueId();
			int kills = plugin.getKillsPorJugador().getOrDefault(killerId, 0);
			plugin.getKillsPorJugador().put(killerId, kills + 1);
		}
	}
	

	@EventHandler
	public void alRespawnear(PlayerRespawnEvent pre) {
		Player jugador = pre.getPlayer();
		String teamName = plugin.getTeamByPlayer(jugador);
		Location loc = plugin.getTeamSpawn(teamName);
		jugador.teleport(loc);
		
	}
	
	@EventHandler
	public void romperBloques(BlockBreakEvent bbe) {
		bbe.setCancelled(true);
	}

	@EventHandler
	public void colocarBloques(BlockPlaceEvent bpe) {
		bpe.setCancelled(true);
	}

	@EventHandler
	public void droppearItems(PlayerDropItemEvent pdie) {
		pdie.setCancelled(true);
		
	}

}
