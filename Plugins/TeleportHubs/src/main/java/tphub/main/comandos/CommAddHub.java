package tphub.main.comandos;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import tphub.main.Main;

public class CommAddHub implements CommandExecutor {

	private Main plugin;

	public CommAddHub(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("No puedes ejecutar este comando desde la consola");
			return false;
		} else {
			Player jugador = (Player) sender;
			if (label.equals("addhub")) {
				if (args.length == 1 && args[0].equalsIgnoreCase("home")) {
					FileConfiguration config = plugin.getConfig();
					String home = args[0];
					Location loc = jugador.getLocation();
					String world = loc.getWorld().getName();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					UUID uuid = jugador.getUniqueId();

					config.set("Player." + uuid + ".Hubs." + home + ".world",world);
					config.set("Player." + uuid + ".Hubs." + home + ".x",x);
					config.set("Player." + uuid + ".Hubs." + home + ".y",y);
					config.set("Player." + uuid + ".Hubs." + home + ".z",z);

					plugin.saveConfig();

					jugador.sendMessage("Se agego 'Home' a su lista de Hubs");

				} else if(args.length == 1 && !args[0].equalsIgnoreCase("home")){
					FileConfiguration config = plugin.getConfig();
					String hubname = args[0];
					Location loc = jugador.getLocation();
					String world = loc.getWorld().getName();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					UUID uuid = jugador.getUniqueId();

					config.set("Player." + uuid + ".Hubs." + hubname + ".world",world);
					config.set("Player." + uuid + ".Hubs." + hubname + ".x",x);
					config.set("Player." + uuid + ".Hubs." + hubname + ".y",y);
					config.set("Player." + uuid + ".Hubs." + hubname + ".z",z);

					plugin.saveConfig();

					jugador.sendMessage("Hub " + hubname + " agregada con éxito.");
				}

			} else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /hubhelp para conocer los comandos disponibles");

			}

			return true;
		}

	}

}
