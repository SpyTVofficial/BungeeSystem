package org.LSN.Main;

import org.LSN.Commands.BCCMD;
import org.LSN.Commands.DiscordCMD;
import org.LSN.Commands.GotoCMD;
import org.LSN.Commands.HubCMD;
import org.LSN.Commands.KickCMD;
import org.LSN.Commands.PingCMD;
import org.LSN.Commands.ReportCMD;
import org.LSN.Commands.TeamCMD;
import org.LSN.Commands.TeamChatCMD;
import org.LSN.Commands.WartungCMD;
import org.LSN.Listener.PostLoginListener;
import org.LSN.MySQL.Connect;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	public static boolean maintenance = false;
	
	public void onEnable() {
		init();
	}

	private void init() {
		Connect.connect();
		Connect.createTable();
		Main.maintenance = true;
		getProxy().getPluginManager().registerCommand(this, new BCCMD());
		getProxy().getPluginManager().registerCommand(this, new DiscordCMD());
		getProxy().getPluginManager().registerCommand(this, new GotoCMD());
		getProxy().getPluginManager().registerCommand(this, new HubCMD());
		getProxy().getPluginManager().registerCommand(this, new KickCMD());
		getProxy().getPluginManager().registerCommand(this, new PingCMD());
		getProxy().getPluginManager().registerCommand(this, new ReportCMD());
		getProxy().getPluginManager().registerCommand(this, new TeamCMD());
		getProxy().getPluginManager().registerCommand(this, new TeamChatCMD());
		getProxy().getPluginManager().registerCommand(this, new WartungCMD());
		
		getProxy().getPluginManager().registerListener(this, new PostLoginListener());
	}

}
