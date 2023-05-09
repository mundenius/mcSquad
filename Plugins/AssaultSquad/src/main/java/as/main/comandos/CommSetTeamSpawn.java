package as.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import as.main.Main;

public class CommSetTeamSpawn implements CommandExecutor{

	private Main plugin; 
	
	public CommSetTeamSpawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			//msje por consola servidor
			Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
			return false; 
		}else {
			Player jugador = (Player) sender;
			String teamName = args[0];
			Location loc = jugador.getLocation();
			if(label.equalsIgnoreCase("setTeamSpawn")) {
				if(args.length == 1) {
					plugin.setTeamSpawn(teamName, loc);
					sender.sendMessage("Team Spawn setteado para el equipo " + ChatColor.DARK_AQUA + teamName);
					return true;
				}else {
					jugador.sendMessage("Comando incorrecto usa: /setTeamSpawn equipo para settear un nuevo spawn");
					return false; 
				}
			}
		}
		
		return true;
	}

}
