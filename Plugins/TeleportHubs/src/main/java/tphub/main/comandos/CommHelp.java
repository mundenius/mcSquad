/**@author mundenius */
package tphub.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tphub.main.Main;

public class CommHelp implements CommandExecutor{

private Main plugin;
	
	public CommHelp(Main plugin) {
		this.plugin = plugin;
	}
	/**@category Comandos
	 * @param Help
	 * Es uno de los comandos principales que da la informacion al usuario de todos los comandos disponibles
	 *  */

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
			return false;
		}else {
			Player jugador = (Player) sender;
			if(args.length ==0) {
				System.out.println("Paso condicion de args.length == 0");
				// /help 0 args
				// /help smthng  1 args
				
				
				if(label.equalsIgnoreCase("hubhelp")) {
					jugador.sendMessage(ChatColor.BOLD + "Comandos disponibles:" 
							+ChatColor.GREEN +"\n/hubhelp   " + ChatColor.WHITE + "Muestra todos los comandos disponibles\n"
							+ChatColor.GREEN +"/reload   " +ChatColor.WHITE + "Recarga el plugin\n"
							+ChatColor.GREEN +"/addhub nombreHub   " +ChatColor.WHITE + "Agrega la posicion en la que estas como hub a tu listado de Hubs disponibles\n" 
							+ChatColor.GREEN +"/removehub nombreHub   " +ChatColor.WHITE + "Elimina hubs de la lista de Hubs disponibles\n"
							+ChatColor.GREEN +"/showhubs   " +ChatColor.WHITE + "Muestra todas las Hubs que tienes disponibles\n");
				}
				
			}else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /hubhelp");
			}
		}
		return true;
	}



}
