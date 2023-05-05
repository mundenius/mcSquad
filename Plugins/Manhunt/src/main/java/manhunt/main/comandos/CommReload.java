package manhunt.main.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import manhunt.main.Main;

public class CommReload implements CommandExecutor{

	private Main plugin;
	
	public CommReload(Main plugin) {
		this.plugin = plugin; 
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("["+plugin.nombre +"]" + " No puedes ejecutar este comando desde la consola");
			return false;
		}else {
			Player jugador = (Player) sender;
			if(label.equals("reload")) {
				if(args.length == 0) {
					plugin.reloadConfig();
					Bukkit.getServer().broadcastMessage(ChatColor.BOLD+ plugin.nombre +ChatColor.WHITE + " Ha sido recargado correctamente");
				}else {
					jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /reload");
				}
			} else {
				jugador.sendMessage(ChatColor.WHITE + "Comando incorrecto; utiliza /reload");
			}
		}
		return true;
	}
	
}
