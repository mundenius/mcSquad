package as.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import as.main.Main;
import as.main.manager.AssaultSquad;

public class CommEstados implements CommandExecutor{
	
	private Main plugin; 
	
	public CommEstados(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Xupalo karol dance");
			return false;
			
		}else {
			Player jugador = (Player) sender; 
			if(args.length > 0) {
				jugador.sendMessage("Comando incorrecto, usa /squadhelp para conocer los comandos disponibles");

			}else {
			if(!label.isEmpty()) {
				if(label.equalsIgnoreCase("start")) {
					AssaultSquad as = new AssaultSquad(plugin);
					as.startGame();
				}else if(label.equalsIgnoreCase("pause")) {
					
					//llamado metodo  a detener el temporizador
				}
				else {
					jugador.sendMessage("Comando incorrecto, usa /squadhelp para conocer los comandos disponibles");
				}
			}
			}
			return true; 
		}
	}

}
