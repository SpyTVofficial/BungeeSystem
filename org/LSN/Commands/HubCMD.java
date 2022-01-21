package org.LSN.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCMD extends Command {

	public HubCMD() {
		super("hub");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.sendMessage("§8Zur Lobby teleportieren...");
		p.connect(BungeeCord.getInstance().getServerInfo("Lobby"));
		p.sendMessage("§6Erfolgreich zur Lobby teleportiert!");
		
//		}
	}

	
}
