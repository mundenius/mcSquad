package manhunt.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import manhunt.main.Main;

public class Entrar implements Listener{

	private Main plugin; 
	
	public Entrar(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void alEntrar(PlayerJoinEvent event) {
		 Player jugador = event.getPlayer();
		 
		 FileConfiguration config = plugin.getConfig();
		 String path = "Config.mensaje-bienvenida";
		 if(config.getString(path).equals("true")) {
			 String texto = "Config.mensaje-bienvenida-texto";
			 jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(texto)).replaceAll("%", jugador.getName()));
			 Bukkit.getConsoleSender().sendMessage(config.getString(texto));
		 }
		 jugador.sendMessage(ChatColor.GOLD + "\n/helpme para conocer los comandos del plugin");
	}
}
