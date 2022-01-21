package org.LSN.Commands;

import org.LSN.Main.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WartungCMD extends Command {

	public WartungCMD() {
		super("wartung");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.hasPermission("System.Wartung.Command")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("an")) {
					Main.maintenance = true;
					for(ProxiedPlayer pp : ProxyServer.getInstance().getPlayers()) {
						if(!pp.hasPermission("System.Wartung.Bypass")) {
							pp.disconnect("§b§lLittle§f§lSpy§c§lNetwork§r\n\n§cDu wurdest vom Netzwerk gekickt! \n\n§aDer Wartungsmodus wurde aktiviert!");
						}
						p.sendMessage("§cWartungsmodus wurde §aaktiviert§c!");
					}
				} else if(args[0].equalsIgnoreCase("aus")){
					Main.maintenance = false;
					p.sendMessage("§cWartungsmodus wurde deaktiviert!");
				}
			} else {
				p.sendMessage("§cBenutzung: /wartung <an/aus>");
			}
		} else {
			p.sendMessage("§cKeine Rechte!");
		}

	}

}
