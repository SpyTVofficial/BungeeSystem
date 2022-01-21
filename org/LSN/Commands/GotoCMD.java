package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GotoCMD extends Command {

	public GotoCMD() {
		super("goto");
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if(p.hasPermission("System.Goto")) {
			if (args.length == 1) {
				String targetname = args[0];
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetname);
				if (target != null) {
					if(p.getServer().getInfo() != target.getServer().getInfo()) {
						p.connect(target.getServer().getInfo());
						p.sendMessage("§cDu wirst auf den Server verschoben...");
					} else {
						p.sendMessage("§cDu bist bereits auf dem Server!");
					}
				} else {
					p.sendMessage("§cSpieler existiert nicht, oder ist nicht online!");
				}
			} else {
				p.sendMessage("§cBenutzung: /goto <Spieler>");
			}
		} else {
			p.sendMessage("§cKeine Rechte!");
		}
	}

}
