/**@author mundenius */
package manhunt.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import manhunt.main.Main;

public class SwitchNether implements CommandExecutor{

	private Main plugin;
	
	public SwitchNether(Main plugin) {
		this.plugin = plugin;
	}

	
	/**@category Comandos
	 * @param Switch Nether
	 * Este comando activa y desactiva el tracking en la dimension del Nether
	 *  */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
			return false; 
		}else {
			Player jugador = (Player) sender;
			if(label.equals("switchnether")) {
				if(args.length == 0) {
					FileConfiguration config = plugin.getConfig();
					config.set("nethertracking", !config.getBoolean("nethertracking", false));
					plugin.saveConfig();
					plugin.reloadConfig();
					if(config.getBoolean("nethertracking")) {
						Bukkit.getServer().broadcastMessage("Tracking en el Nether: Activado");
					}
					else {
						Bukkit.getServer().broadcastMessage("Tracking en el Nether: Desactivado");

					}
				}else {
					jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /switchnether");
				}
			}
			return true; 
		}
	}
	
}
