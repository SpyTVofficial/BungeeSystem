package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class KickCMD extends Command {

	public KickCMD() {
		super("kick");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("System.Kick")) {
			if (args.length == 1) {
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
				if (args[0].equalsIgnoreCase(target.getDisplayName())) {
					target.disconnect(new TextComponent("§b§lLittle§f§lSpy§c§lNetwork§r\n\n§cDu wurdest vom Netzwerk gekickt! \n\n von " + sender.getName()));
					sender.sendMessage("§a" + target.getDisplayName() + " §cwurde vom Netzwerk gekickt!");
				} else {
					sender.sendMessage("§cSpieler existiert nicht, oder ist nicht online!");
				}
//			p.sendMessage();
			} else if (args.length >=1 ){
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
				String reason = "";
				for (int i = 1; i < args.length; i++)
					reason = reason + args[i] + " ";
				target.disconnect(new TextComponent("§b§lLittle§f§lSpy§c§lNetwork§r\n\n§cDu wurdest vom Netzwerk gekickt! \n\n von " + sender.getName() + "\n\n§cGrund: " + reason));
				sender.sendMessage("§a" + target.getDisplayName() + " §cwurde vom Netzwerk gekickt!");
			} else {
				sender.sendMessage("§cBenutzung: /kick <Spieler> (<Grund>)");
			}
		} else {
			sender.sendMessage("§cKeine Rechte!");
		}
	}
}
