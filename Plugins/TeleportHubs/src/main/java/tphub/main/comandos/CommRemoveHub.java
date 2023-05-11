package tphub.main.comandos;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import tphub.main.Main;

public class CommRemoveHub implements CommandExecutor{

	private Main plugin; 
	
	public CommRemoveHub(Main plugin) {
		this.plugin = plugin;
	}
	
	
	/**@category Comandos
	 * @param RemoveHub
	 * Comando que sirve para eliminar Hubs del archivo config
	 *  */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("No puedes ejecutar este comando desde la consola");
			return false;
		} else {
			System.out.println("dentro else");
			Player jugador = (Player) sender;
			if (label.equals("removehub")) {
				System.out.println("dentor de removehub");
				if (args.length == 1 && args[0].equalsIgnoreCase("home")) {
					System.out.println("entro removehub home");
					FileConfiguration config = plugin.getConfig();
					String home = args[0];
					UUID uuid = jugador.getUniqueId();

					config.set("Player." + uuid + ".Hubs." + home,null);

					plugin.saveConfig();

					jugador.sendMessage("Se elimino 'Home' de su lista de Hubs");

				} else if(args.length == 1 && !args[0].equalsIgnoreCase("home")){
					FileConfiguration config = plugin.getConfig();
					String hubname = args[0];
					UUID uuid = jugador.getUniqueId();
					if(config.contains("Player." + uuid + ".Hubs." + hubname)) {
						config.set("Player." + uuid + ".Hubs." + hubname,null);
						
						plugin.saveConfig();
						
						jugador.sendMessage("Hub " + hubname + " eliminada con éxito.");
					}else {
						jugador.sendMessage("No se ha encontrado una Hub con el nombre proporcionado");
					}

				}

			} else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /hubhelp para conocer los comandos disponibles");

			}

			return true;
		}
	}

}
