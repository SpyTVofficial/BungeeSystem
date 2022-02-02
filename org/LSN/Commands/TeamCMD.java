package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamCMD extends Command {
	
	public TeamCMD() {
		super("team");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.sendMessage("");
		p.sendMessage("§4§LProjektleitung");
		p.sendMessage("   §4§litsSpyTV ");
		p.sendMessage("");
		p.sendMessage("§4§lAdministration");
		p.sendMessage("   §4§lKevbchef");
		p.sendMessage("");
	}

}
