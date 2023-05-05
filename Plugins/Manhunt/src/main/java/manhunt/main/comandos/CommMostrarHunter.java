/**@author mundenius */
package manhunt.main.comandos;

import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import manhunt.main.Main;

public class CommMostrarHunter implements CommandExecutor{

	 private Main plugin;

	    public CommMostrarHunter(Main plugin) {
	        this.plugin = plugin;
	    }

	    /**@category Comandos
		 * @param Mostrar Hunters
		 * Este comando sirve para desplegar una lista de los jugadores que son Hunters
		 *  */
		@Override
		public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			// TODO Auto-generated method stub
			if(!(sender instanceof Player)) {
				Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
				return false;
			}else {
				Player jugador = (Player) sender;
				if(label.equals("showhunters")) {
					if(args.length == 0) {
						Set<UUID> idHunters = plugin.getHuntersId();
						if(idHunters.isEmpty()) {
							jugador.sendMessage("No existen cazadores actualmente");
						}else {
							mostrarListaHunters(jugador, idHunters);
						}
					}else {
						jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /showhunters I");
					}
				}else {
					jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /showhunters");

				}
				return true;
			}
		}
		
		/**@category Metodo Auxiliar
		 * @param mostrarListaHunters
		 * Este metodo auxiliar itera dentro del SET y los muestra como mensaje al jugador
		 *  */
		public void mostrarListaHunters(Player player, Set<UUID> ids) {
		    player.sendMessage(ChatColor.BOLD + "List of hunters:");
		    for (UUID uuid : ids) {
		        Player hunter = Bukkit.getPlayer(uuid);
		        if (hunter != null) {
		            player.sendMessage(ChatColor.WHITE + "- " + hunter.getName() + "\n");
		        }
		    }
		}
}
