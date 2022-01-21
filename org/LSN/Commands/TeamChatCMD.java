package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamChatCMD extends Command {
	
	public TeamChatCMD() {
		super("tc");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if(p.hasPermission("System.TeamChat")) {
			if(args.length >= 1) {
				String msg = "";
				for (int i = 0; i < args.length; i++)
					msg = msg + args[i] + " ";
				for (ProxiedPlayer pp : ProxyServer.getInstance().getPlayers()) {
					pp.sendMessage("§8[§cTeamChat§8] §c" + p.getDisplayName() + "§7: " + msg);
				}
			} else {
				p.sendMessage("§cBenutzung: /tc <Nachricht>");
			}
		} else {
			p.sendMessage("§cKeine Rechte!");
		}
	}
	
	

}
