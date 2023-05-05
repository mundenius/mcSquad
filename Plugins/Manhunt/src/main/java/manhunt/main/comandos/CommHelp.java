/**@author mundenius */
package manhunt.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import manhunt.main.Main;

public class CommHelp implements CommandExecutor{

private Main plugin;
	
	public CommHelp(Main plugin) {
		this.plugin = plugin;
	}
	/**@category Comandos
	 * @param Help y Reload
	 * Al ser comandos especiales, uno de informacion y otro de recarga, decidi dejarlos en la misma clase
	 * El comando /help muestra todos los comandos disponibles y su syntaxis para que el jugador pueda hacer uso de ellos
	 * El comando /reload recarga el plugin
	 *  */
	@Override
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
				
				
				if(label.equalsIgnoreCase("helpme")) {
					jugador.sendMessage(ChatColor.BOLD + "Comandos disponibles:" 
							+ChatColor.GOLD +"\n/helpme   " + ChatColor.WHITE + "Muestra todos los comandos disponibles\n"
							+ChatColor.GOLD +"/reload   " +ChatColor.WHITE + "Recarga el plugin\n"
							+ChatColor.GOLD +"/addhunter playerName   " +ChatColor.WHITE + "Agrega a un jugar como CAZADOR\n" 
							+ChatColor.GOLD +"/removehunter playerName   " +ChatColor.WHITE + "Elimina al jugador como CAZADOR\n"
							+ChatColor.GOLD +"/showhunters   " +ChatColor.WHITE + "Muestra a todos los jugadores que son CAZADORES\n"
							+ChatColor.GOLD +"/netherswitch   " +ChatColor.WHITE + "Activa o desactiva el tracking en el nether\n"
							+ChatColor.GOLD +"/cleanstart   " +ChatColor.WHITE + "Elimina todo el inventario de los jugadores (Repone la brujula a los CAZADORES)\n");
				}
				
			}else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /helpme");
			}
		}
		return true;
	}
	
	
}
