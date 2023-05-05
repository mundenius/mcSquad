/**@author mundenius */
package tphub.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tphub.main.comandos.CommAddHub;
import tphub.main.comandos.CommHelp;
import tphub.main.comandos.CommReload;
import tphub.main.comandos.CommShowHub;
import tphub.main.comandos.CommTpHub;
import tphub.main.comandos.CommRemoveHub;
import tphub.main.eventos.Entrar;

public class Main extends JavaPlugin{

	PluginDescriptionFile file = getDescription();
	public String version = file.getVersion();
	public String nombre = file.getName();
	
	/**@param Ruta Config
	 * Se define para utilizar en metodo auxiliar que registra el archivo de configuraciones config.yml
	 *  */
	String rutaConfig;
	
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
		this.getCommand("hubhelp").setExecutor(new CommHelp(this));
		this.getCommand("reload").setExecutor(new CommReload(this));
		this.getCommand("addhub").setExecutor(new CommAddHub(this));
		this.getCommand("removehub").setExecutor(new CommRemoveHub(this));
		this.getCommand("showhubs").setExecutor(new CommShowHub(this));
		this.getCommand("tphub").setExecutor(new CommTpHub(this));
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
}
