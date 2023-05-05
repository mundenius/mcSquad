/**@author mundenius */
package as.main;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
	
	/**@param  MAP<String, Set<UUID>>
	 * Se define un map que recibe un String y un set de UUID, para crear los equipos. 
	 * */
	
	public Map<String, Set<UUID>> teams = new HashMap<>();
	
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
	
	public Map<String, Set<UUID>> getTeams(){
		return this.teams;
	}
	
	
}

