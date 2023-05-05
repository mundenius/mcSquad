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


public class CommAgregarHunter implements CommandExecutor{
	
	private Main plugin;
	
	public CommAgregarHunter(Main plugin) {
		this.plugin = plugin;
	}

	/**@category Comandos
	 * @param Agregar Hunter
	 * Este comando se utiliza para agregar jugadores al SET de hunters definido en el main
	 *  */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
			return false;
		}else {
			Player jugador = (Player) sender;
			// /addhunter 1 args[0]
			// /addhunter StonerLord 2 args[1]
			if(label.equals("addhunter")){
				if(args.length == 1) {
					Player hunter = (Bukkit.getServer().getPlayerExact(args[0]));
					if(hunter != null) {
						if(!plugin.getHuntersId().contains(hunter.getUniqueId())) {
							plugin.addHunter(hunter);
							hunter.getInventory().addItem(new ItemStack(Material.COMPASS, 1));
							Bukkit.getServer().broadcastMessage(ChatColor.AQUA + hunter.getName() + ChatColor.WHITE + " es un cazador");
						}else {
							jugador.sendMessage(ChatColor.AQUA + hunter.getName() + ChatColor.WHITE + " ya es un cazador");
						}
					}else {
						jugador.sendMessage(ChatColor.AQUA + args[1] + ChatColor.WHITE + " No se ha encontrado");
					}
					
				}else {
					jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /addhunter nombreJugador");
				}
				
			}else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /addhunter nombreJugador");
			}
			return true;
		}
	}

}
