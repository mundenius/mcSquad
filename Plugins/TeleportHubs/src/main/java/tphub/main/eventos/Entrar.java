package tphub.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import tphub.main.Main;

public class Entrar implements Listener{

	private Main plugin;
	
	public Entrar(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	
	public void alEntrar(PlayerJoinEvent pje) {
		Player jugador = pje.getPlayer();
		FileConfiguration config = plugin.getConfig();
		 String path = "Config.mensaje-bienvenida";
		 if(config.getString(path).equals("true")) {
			 String texto = "Config.mensaje-bienvenida-texto";
			 jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(texto)).replaceAll("%", jugador.getName()));
			 Bukkit.getConsoleSender().sendMessage(config.getString(texto));
		 }
		 jugador.sendMessage(ChatColor.DARK_GREEN + "\n/hubhelp para conocer los comandos del plugin");
	}
}
