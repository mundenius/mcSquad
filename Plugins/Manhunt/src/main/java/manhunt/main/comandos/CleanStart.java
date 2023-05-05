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

public class CleanStart implements CommandExecutor{

	private Main plugin; 
	
	public CleanStart(Main plugin) {
		this.plugin = plugin;
	}

	/**@category Comandos
	 * @param Clean Start
	 * Con este comando se garantiza que todos los jugadores partiran desde cero
	 * Tambien se agrega la logica, de que si el jugador es un hunter, se le restituira la brujula
	 *  */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
			return false;
		}else {
			Player jugador = (Player) sender;
			if(label.equals("cleanstart")) {
				if(args.length == 0) {
					for(Player player : Bukkit.getOnlinePlayers()) {
						player.getInventory().clear();
						if(plugin.getHuntersId().contains(jugador.getUniqueId())) {
							player.getInventory().addItem(new ItemStack(Material.COMPASS));
						}
					}
					Bukkit.getServer().broadcastMessage(ChatColor.BOLD + "El inventario de todos los jugadores ha sido limpiado\nBrujulas restituidas a los cazadores");
				}else {
					jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /cleanstart");
				}
			}
			return true; 
		}
	}
	
	
}
