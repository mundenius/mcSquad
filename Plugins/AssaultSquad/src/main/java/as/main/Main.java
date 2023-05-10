/**@author mundenius */
package as.main;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import as.main.comandos.CommEstados;
import as.main.comandos.CommHelp;
import as.main.eventos.Entrar;

public class Main extends JavaPlugin{

	/**Se definen atributos que se heredan del archivo plugin.yml */
	PluginDescriptionFile file = getDescription();
	public String version = file.getVersion();
	public String nombre = file.getName();
	
	/**@param Ruta Config
	 * Se define para utilizar en metodo auxiliar que registra el archivo de configuraciones config.yml
	 *  */
	String rutaConfig;
	
	/**@param  MAP<String, Set<UUID>> || MAP<String, Location>
	 * Se define un map que recibe un String y un set de UUID, para crear los equipos. 
	 * Se define un map que recibe un String y un objeto del tipo Location para crear los puntos de spawn de los equipos
	 * 
	 * */
	private Map<String, Location> teamSpawns = new HashMap<>();
	public Map<String, Set<UUID>> teams = new HashMap<>();
	private HashMap<UUID, Integer> killsPorJugador = new HashMap<>();

	
	/**@method Al Iniciar: Cuando se inicia el plugin se ejecuta todo lo que esta dentro del metodo */
	public void onEnable() {
		registrarComandos();
		registrarConfig();
		registrarEventos();
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "------------------------------------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + nombre + ChatColor.WHITE + " -> Activado Correctamente\nVersion: "  + version);
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "------------------------------------");
	}
	
	/**@method Al Desactivar: Cuando se desactiva el plugin, se ejecuta lo que esta dentro de este metodo */
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "------------------------------------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + nombre + ChatColor.WHITE +  " -> Desactivado Correctamente\nVersion: " + version);
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "------------------------------------");

	}
	
	/**@category Metodo Registro
	 * @param Registrar Comandos
	 * Metodo auxiliar que registra los comandos del plugin
	 *  */
	public void registrarComandos() {
		this.getCommand("squadhelp").setExecutor(new CommHelp(this));
		this.getCommand("start").setExecutor(new CommEstados(this));
	}
	
	/**@category Metodo Registro
	 * @param Registrar Eventos
	 * Metodo auxiliar para registrar eventos en el juego
	 *  */
	public void registrarEventos() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Entrar(this), this);
	}
	
	/**@category Metodo Registro
	 * @param Registrar Configuracion
	 * Registra las configuraciones del plugin
	 *  */
	public void registrarConfig() {
		File config = new File(this.getDataFolder(),"config.yml");
		rutaConfig = config.getPath();
		if(!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}
	

	public void setTeamSpawn(String teamName, Location location) {
	    teamSpawns.put(teamName, location);
	}

	public Location getTeamSpawn(String teamName) {
	    return teamSpawns.get(teamName);
	}
	
	public Map<String, Set<UUID>> getTeams(){
		return this.teams;
	}
	
	public Set<UUID> getTeamMatesByTeam(String teamName){
		return teams.get(teamName);
	}
	
	public String getTeamByPlayer(Player player) {
	    UUID playerId = player.getUniqueId();
	    for (String teamName : teams.keySet()) {
	        if (teams.get(teamName).contains(playerId)) {
	            return teamName;
	        }
	    }
	    return null; // El jugador no está en ningún equipo
	}
	
	public HashMap<UUID, Integer> getKillsPorJugador() {
		return killsPorJugador;
	}
	
	public void addTeam(String teamName){
		teams.put(teamName, new HashSet<>());
	}
	
	public void removeTeam(String teamName) {
		teams.remove(teamName, new HashSet<>());
	}
	
	public void addPlayerToTeam(String teamName, Player player) {
	    UUID playerId = player.getUniqueId();
	    Set<UUID> teamMates = teams.getOrDefault(teamName, new HashSet<>());
	    teamMates.add(playerId);
	    teams.put(teamName, teamMates);
	}

	public void removePlayerFromTeam(String teamName, Player player) {
	    UUID playerId = player.getUniqueId();
	    Set<UUID> teamMates = teams.getOrDefault(teamName, new HashSet<>());
	    teamMates.remove(playerId);
	    teams.put(teamName, teamMates);
	}
}

