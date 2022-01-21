package org.LSN.Listener;

import org.LSN.Main.Main;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PostLoginListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onConnect(PostLoginEvent e) {
		ProxiedPlayer p = e.getPlayer();
		if (Main.maintenance == true) {
			if (!p.hasPermission("System.Wartung.Bypass")) {
				p.disconnect("§b§lLittle§f§lSpy§c§lNetwork§r\n\n§cDer Server befindet sich aktuell im Wartungsmodus!");
			}
		}
	}

}
