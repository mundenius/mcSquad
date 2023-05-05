/**@author mundenius */
package manhunt.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import manhunt.main.Main;

public class CommEliminarHunter implements CommandExecutor{

	private Main plugin;
	
	public CommEliminarHunter(Main plugin) {
		this.plugin = plugin;
	}

	/**@category Comandos
	 * @param Eliminar Hunter
	 * Este comando remueve a jugadores del SET de hunters que se define en el Main
	 *  */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.BOLD + plugin.nombre + ChatColor.WHITE + " No puedes ejecutar este comando desde la consola");
			return false;
		}else {
			Player jugador = (Player) sender;
			if(label.equals("removehunter")) {
				if(args.length == 1) {
					Player hunter = (Bukkit.getServer().getPlayerExact(args[0]));
					if(hunter != null) {
						if(plugin.getHuntersId().contains(hunter.getUniqueId())) {
							hunter.getInventory().remove(new ItemStack(Material.COMPASS, 1));
							Bukkit.getServer().broadcastMessage(ChatColor.AQUA + hunter.getName() + ChatColor.WHITE + " Ya no es un cazador");
							plugin.removeHunter(hunter);
						}else {
							jugador.sendMessage(ChatColor.AQUA + args[0] + ChatColor.WHITE + " No es un cazador");
						}
					}else {
						jugador.sendMessage(ChatColor.AQUA + args[0] + ChatColor.WHITE + " No se ha encontrado al jugador");
					}
				}
				else {
					jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /removehunter nombreJugador");
				}
			}else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /removehunter nombreJugador");

			}
			return true;
		}
		
	}
	
}
