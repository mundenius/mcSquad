package as.main.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import as.main.Main;

public class AssaultSquad {

	private Main plugin;
	private int currentTime;
	private int tiempoMaximo;
	private int kills;
	private int killsTotales;
	private boolean enPausa;
	private int rondas;
	private HashMap<UUID, Integer> killsPorJugador = new HashMap<>();
	private Map<String, Location> teamSpawns;
	private Map<String, Integer> teamKills;
	ESTADOS state;
	
	
	public AssaultSquad(Main plugin) {
		this.plugin = plugin;
		this.teamSpawns = new HashMap<>();
		this.teamKills = new HashMap<>();
		this.currentTime = 0;
		this.tiempoMaximo = 300;
		this.kills = 0;
		this.killsTotales = 0;
		this.enPausa = false; 
	}
	

	public void startGame() {
		state = ESTADOS.EMPEZANDO;
		rondas = 0;
		this.kills = 0; 
		this.killsTotales = 0;
		nextRound();
	}
	
	public void nextRound() {
		state = ESTADOS.ENRONDAS;
		rondas++;
		startRounds();

	}
	
	public void startRounds() {
		state = ESTADOS.ENRONDAS;
		this.currentTime = 0;
		this.tiempoMaximo = 300;
		ItemStack casco = new ItemStack(Material.TURTLE_HELMET);
        ItemStack pechera = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack botas = new ItemStack(Material.IRON_BOOTS);
        ItemStack[] armorContents = {botas, leggings, pechera, casco};
        
        // Dar items específicos
        ItemStack fisico = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack duro = new ItemStack(Material.IRON_AXE);
        ItemStack rango = new ItemStack(Material.BOW);
        ItemStack comida = new ItemStack(Material.COOKED_BEEF, 32);
        ItemStack flechas = new ItemStack(Material.ARROW, 64);
		
		for (String teamName : teamSpawns.keySet()) {
		    Location teamSpawn = plugin.getTeamSpawn(teamName);
		    if (teamSpawn != null) {
		        teamSpawns.put(teamName, teamSpawn);
		        // Teletransporta a los jugadores al spawn del equipo correspondiente
		        Set<UUID> teamMates = plugin.getTeamMatesByTeam(teamName);
		        for (UUID playerId : teamMates) {
		            Player player = Bukkit.getPlayer(playerId);
		            if (player != null) {
		                player.teleport(teamSpawn);
		                player.getInventory().clear();
		                player.getInventory().setArmorContents(armorContents);
		                player.getInventory().addItem(fisico, rango, comida, flechas);

		                
		            }
		        }
		    }
		}
		
		/**@param Temporizador */
		
		rounds();
		
	}
	
	public void rounds() {
		state = ESTADOS.ENRONDAS;
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
	        @Override
	        public void run() {
	                currentTime++;
	                if (currentTime == tiempoMaximo) {
	                    finishGame();
	                } else {
	                    String timeLeft = String.format("%02d:%02d", TimeUnit.SECONDS.toMinutes(tiempoMaximo - currentTime), TimeUnit.SECONDS.toSeconds(tiempoMaximo - currentTime) % 60);

	                    // Actualiza el scoreboard con el tiempo restante para cada jugador en cada equipo
	                    for (String teamName : plugin.getTeams().keySet()) {
	                        Set<UUID> teamMates = plugin.getTeamMatesByTeam(teamName);
	                        for (UUID playerId : teamMates) {
	                            Player player = Bukkit.getPlayer(playerId);
	                            if (player != null) {
	                            	Scoreboard scoreboard = player.getScoreboard();
	                                Objective objective = scoreboard.getObjective(teamName);
	                                if (objective != null) {
	                                    Score score = objective.getScore(player.getName());
	                                    score.setScore(tiempoMaximo - currentTime);
	                                    score.setScore(Integer.parseInt(timeLeft.replace(":", "")));
	                                }
	                            }
	                        }
	                    }
	                
	            }
	        }
	    }, 0L, 20L);
	    finishRound();
	}
	
	public void finishRound() {
		state = ESTADOS.TERMINANDORONDA;
		HashMap<UUID, Integer> killsPorJugador = plugin.getKillsPorJugador();
	    HashMap<String, Integer> killsPorJugadorPorEquipo = new HashMap<>();
	    for (String teamName : plugin.getTeams().keySet()) {
	        Set<UUID> teamMates = plugin.getTeamMatesByTeam(teamName);
	        int teamKills = 0;
	        for (UUID playerId : teamMates) {
	            int kills = killsPorJugador.getOrDefault(playerId, 0);
	            teamKills += kills;
	        }
	        killsPorJugadorPorEquipo.put(teamName, teamKills);
	    }
	    
	    // Comprueba si se han jugado las tres rondas
	    if (rondas > 3) {
	        finishGame();
	    }else {
	    	nextRound();
	    }
		
	}
	
	public void finishGame() {
		state = ESTADOS.OFF;
		 // Mostrar los resultados del juego
	    for (String teamName : teamKills.keySet()) {
	        killsTotales = teamKills.getOrDefault(teamName, 0);
	        plugin.getServer().broadcastMessage(ChatColor.AQUA + "El equipo " + teamName + " ha obtenido " + killsTotales + " kills");
	    }
		
	}
	
	public enum ESTADOS {
		OFF,EMPEZANDO,ENRONDAS,TERMINANDORONDA;
	}
	
	
}
