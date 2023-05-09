package as.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import as.main.Main;

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
				
				
				if(label.equalsIgnoreCase("squadhelp")) {
					jugador.sendMessage(ChatColor.BOLD + "Comandos disponibles:" 
							+ChatColor.DARK_AQUA +"\n/ashelp   " + ChatColor.WHITE + "Muestra todos los comandos disponibles\n"
							+ChatColor.DARK_AQUA +"/reload   " +ChatColor.WHITE + "Recarga el plugin\n"
							+ChatColor.DARK_AQUA +"/addteam teamName   " +ChatColor.WHITE + "Agrega un equipo\n" 
							+ChatColor.DARK_AQUA +"/removeteam teamName   " +ChatColor.WHITE + "Elimina un equipo\n"
							+ChatColor.DARK_AQUA +"/showteams   " +ChatColor.WHITE + "Muestra todos los equipos\n"
							+ChatColor.DARK_AQUA +"/teamName addmate userName   " +ChatColor.WHITE + "Agrega un integrante al equipo seleccionado\n"
							+ChatColor.DARK_AQUA +"/teamName removemate userName  " +ChatColor.WHITE + "Elimina un integrante del equipo seleccionado\n"
							+ChatColor.DARK_AQUA +"/showmates teamName   " +ChatColor.WHITE + "Muestra todos los integrantes del equipo seleccionado\n"
							+ChatColor.DARK_AQUA +"/start   " +ChatColor.WHITE + "Comienza el juego\n"
							+ChatColor.DARK_AQUA +"/pause   " +ChatColor.WHITE + "Pausa el temporizador el juego\n"
							);
				}
				
			}else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /squadhelp");
			}
		}
		return true;
	}
}
