package tphub.main.comandos;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import tphub.main.Main;

public class CommTpHub implements CommandExecutor {

	private Main plugin;

	public CommTpHub(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("No puedes ejecutar este comando desde la consola");
			return false;
		} else {
			Player jugador = (Player) sender;
			if (label.equals("tphub")) {
				if (args.length == 1) {
					FileConfiguration config = plugin.getConfig();
					String hubName = args[0];
					UUID uuid = jugador.getUniqueId();
					if(hubName.equalsIgnoreCase("home")) {
					    ConfigurationSection homeSection = config.getConfigurationSection("Player." + uuid + ".Hubs." + hubName );

					 if (homeSection != null) {
						    String worldName = homeSection.getString(".world");
						    
						    World world = Bukkit.getWorld(worldName);
						    double x = homeSection.getDouble(".x");
			        	    double y = homeSection.getDouble(".y");
			        	    double z = homeSection.getDouble(".z");
						    Location location = new Location(world, x, y, z);
						    System.out.println(world + "mundo");
						    System.out.println(x + "x");
						    System.out.println(y + "y");
						    System.out.println(z + "z");
					        // Teletransportar al jugador
					        jugador.teleport(location);
					        jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&2") + hubName);
					    } else {
						jugador.sendMessage("No tienes un Home setteado aún");
					}
					return true;

				}
				else if (!hubName.equalsIgnoreCase("home")) {
				    ConfigurationSection hubsSection = config.getConfigurationSection("Player." + uuid + ".Hubs");
				    if (hubsSection == null) {
				        jugador.sendMessage("No tienes ninguna hub guardada.");
				        return false;
				    }
				    
				    String locationString = hubsSection.getString(hubName);
				    if (locationString == null) {
				        jugador.sendMessage("No tienes una hub con ese nombre.");
				        return false;
				    }
				    
		        	String worldName = hubsSection.getString(hubName + ".world");
				    World world = Bukkit.getWorld(worldName);
				    double x = hubsSection.getDouble(hubName + ".x");
	        	    double y = hubsSection.getDouble(hubName + ".y");
	        	    double z = hubsSection.getDouble(hubName + ".z");
				    Location location = new Location(world, x, y, z);
				    
				    jugador.teleport(location);
				    jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2") +hubName);
				    
				    return true;
				}
			} else {
				jugador.sendMessage("Comando incorrecto usa /tphub hubName para teletransportarte");
			}
		}else {
			jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /hubhelp para conocer los comandos disponibles");
		}
			return true;
	}
	}
}


