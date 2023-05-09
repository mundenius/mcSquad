package as.main.eventos;

import java.awt.Event;
import java.util.HashMap;
import java.util.UUID;

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
	public void alMorir(PlayerDeathEvent pde) {

	}

	@EventHandler
	public void alRespawnear(PlayerRespawnEvent pre) {

	}
	
	@EventHandler
	public void romperBloques(BlockBreakEvent bbe) {

	}

	@EventHandler
	public void colocarBloques(BlockPlaceEvent bpe) {

	}

	@EventHandler
	public void droppearItems(PlayerDropItemEvent pdie) {

	}

}
