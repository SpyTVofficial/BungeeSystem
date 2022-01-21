package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class DiscordCMD extends Command {

	public DiscordCMD() {
		super("discord");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.sendMessage("§aKlicke auf den Link, um unserem Discord Server zu joinen!");
		p.sendMessage("§ahttps://discord.com/invite/aPxM7ukeqc");
	}

}
