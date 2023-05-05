/**@author mundenius */
package manhunt.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import manhunt.main.comandos.CleanStart;
import manhunt.main.comandos.CommAgregarHunter;
import manhunt.main.comandos.CommEliminarHunter;
import manhunt.main.comandos.CommHelp;
import manhunt.main.comandos.CommMostrarHunter;
import manhunt.main.comandos.CommReload;
import manhunt.main.comandos.SwitchNether;
import manhunt.main.eventos.Entrar;
import manhunt.main.listeners.CompassClick;
import manhunt.main.listeners.Respawn;

import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
import java.io.File;

public class Main extends JavaPlugin{
	
	/**Se definen atributos que se heredan del archivo plugin.yml */
	PluginDescriptionFile file = getDescription();
	public String version = file.getVersion();
	public String nombre = file.getName();
	
	/**@param Ruta Config
	 * Se define para utilizar en metodo auxiliar que registra el archivo de configuraciones config.yml
	 *  */
	String rutaConfig;
	
	/**@param 
	 * UUID = ID unico universal, es una clase inmutable  
	 * */	 
	private Set<UUID> huntersId = new HashSet<UUID>();
	
	/**@method Al Iniciar: Cuando se inicia el plugin se ejecuta todo lo que esta dentro del metodo */
	public void onEnable() {
		registrarComandos();
		registrarEventos();
		registrarConfig();
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "---------------------------------------------------"); 
		Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + nombre +ChatColor.WHITE + " -> Se activo correctamente\nVersion: " + version); 
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "---------------------------------------------------"); 
	}
	/**@method Al Desactivar: Cuando se desactiva el plugin, se ejecuta lo que esta dentro de este metodo */
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "---------------------------------------------------"); 
		Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + nombre +ChatColor.WHITE + " -> Se desactivo correctamente\nVersion: " + version); 
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "---------------------------------------------------"); 
	}
	
	/**@category Metodo Registro
	 * @param Registrar Comandos
	 * Metodo auxiliar para registrar todos los comandos del plugin, asi mantengo el metodo onEnable limpio
	 *  */
	public void registrarComandos() {
		this.getCommand("helpme").setExecutor(new CommHelp(this));
		this.getCommand("reload").setExecutor(new CommReload(this));
		this.getCommand("cleanstart").setExecutor(new CleanStart(this));
		this.getCommand("addHunter").setExecutor(new CommAgregarHunter(this));
		this.getCommand("removeHunter").setExecutor(new CommEliminarHunter(this));
		this.getCommand("showhunters").setExecutor(new CommMostrarHunter(this));
		this.getCommand("switchnether").setExecutor(new SwitchNether(this));
	}
	/**@category Metodo Registro
	 * @param Registrar Eventos
	 * Metodo auxiliar para registrar eventos en el juego
	 *  */
	public void registrarEventos() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Entrar(this), this);
		pm.registerEvents(new CompassClick(this), this);
		pm.registerEvents(new Respawn(this), this);
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
	
	/**@category Metodo Auxiliar
	 * @param getHuntersId
	 * Metodo auxiliar que retorna los ID de los jugadores a los que se les ha asignado el rol de CAZADOR
	 *  */
	public Set<UUID> getHuntersId(){
		return this.huntersId;
	}
	
	/**@category Metodo Auxiliar
	 * @param addHunter
	 * Metodo auxiliar para agregar cazadores al SET de UUID
	 *  */
	public void addHunter(Player hunter) {
		huntersId.add(hunter.getUniqueId());
	}
	
	/**@category Metodo Auxiliar
	 * @param removeHunter
	 * Metodo auxiliar para eliminar cazadores al SET de UUID
	 *  */
	public void removeHunter(Player hunter) {
		huntersId.remove(hunter.getUniqueId());
	}
}
