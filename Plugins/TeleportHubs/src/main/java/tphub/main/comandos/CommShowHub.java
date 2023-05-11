package tphub.main.comandos;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import tphub.main.Main;

public class CommShowHub implements CommandExecutor{
	private Main plugin;
	
	public CommShowHub(Main plugin) {
		this.plugin = plugin;
	}

	/**@category Comandos
	 * @param ShowHub
	 * Comando que sirve para mostrar las Hubs del jugador que ejecuta el comando
	 *  */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("No puedes ejecutar este comando desde la consola");
			return false;
		}else {
			Player jugador = (Player) sender;
			if(label.equalsIgnoreCase("showhubs")) {
				FileConfiguration config = plugin.getConfig();
				ConfigurationSection hubsSection = config.getConfigurationSection("Player." + jugador.getUniqueId() + ".Hubs");
				if (hubsSection == null) {
					jugador.sendMessage("No tienes ninguna hub guardada.");
					return true;
				}
				Set<String> hubKeys = hubsSection.getKeys(false);
				
				if (hubKeys.isEmpty()) {
					jugador.sendMessage("No tienes ninguna hub guardada.");
					return true;
				}
				
				for (String hub : hubKeys) {
					String worldName = hubsSection.getString(hub + ".world");
					double x = hubsSection.getDouble(hub + ".x");
					double y = hubsSection.getDouble(hub + ".y");
					double z = hubsSection.getDouble(hub + ".z");
					World world = Bukkit.getWorld(worldName);
					Location location = new Location(world, x, y, z);
					Biome biome = location.getBlock().getBiome();
					
					jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2" + hub) +ChatColor.RESET + ChatColor.ITALIC + "\nBioma: " + biome.name());
				}
				
			}else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /hubhelp para conocer los comandos disponibles");

			}
			return true;
		}
	}

}
