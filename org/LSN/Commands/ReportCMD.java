package org.LSN.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportCMD extends Command {

	public ReportCMD() {
		super("report");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 2) {
			String target = args[0];
			String reason = args[1];
			if(ProxyServer.getInstance().getPlayer(target) != null) {
				for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
					if(team.hasPermission("System.Reports")) {
						team.sendMessage("");
						team.sendMessage("§4§lNeuer Report");
						team.sendMessage("§8von: §c" + p.getDisplayName());
						team.sendMessage("§8Spieler: §c" + target.toString());
						team.sendMessage("§8Grund: §c" + reason);
						TextComponent gotoreport = new TextComponent("§a§lZum Spieler teleporteren");
						gotoreport.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/goto " + target));
						team.sendMessage(gotoreport);
						team.sendMessage("");
					}
				p.sendMessage("§aDanke für deine Hilfe! Dein Report wurde erfolgreich ans Team gesendet!");
				}
			} else {
				p.sendMessage("§cSpieler ist nicht online!");
			}
		} else {
			p.sendMessage("§cBenutzung: /report <Spieler> <Grund>");
		}
	}

}
