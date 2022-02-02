package org.LSN.Listener;

import java.sql.PreparedStatement;
import java.util.UUID;

import org.LSN.Main.Main;
import org.LSN.MySQL.Connect;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PostLoginListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onConnect(PostLoginEvent e) {
		ProxiedPlayer p = e.getPlayer();
		String playername = p.getDisplayName();
		UUID playeruuid = p.getUniqueId();
        String pUUID = "" + playeruuid;
		try {
			String Query="INSERT IF NOT EXISTS INTO users (name, uuid) VALUES (?, ?);";
            PreparedStatement prStmt = Connect.con.prepareStatement(Query);
            prStmt.setString(1,  playername);
            prStmt.setString(2,  pUUID);

           
            prStmt.execute();
           

		} catch (Exception ex) {
			System.err.println("Couldnt cast the Query! Error:");
			System.err.println(ex.getMessage());
		}
		if (Main.maintenance == true) {
			if (!p.hasPermission("System.Wartung.Bypass")) {
				p.disconnect("§b§lLittle§f§lSpy§c§lNetwork§r\n\n§cDer Server befindet sich aktuell im Wartungsmodus!");
			}
		}
		p.setTabHeader(new TextComponent("§c§lLittle§f§lSpy§b§lGames\n§e§lAlpha Netzwerk"),
				new TextComponent("§aSpieler Online: §a" + BungeeCord.getInstance().getOnlineCount() + "§a/100"));
	}

}
