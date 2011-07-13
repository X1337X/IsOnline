package x1337x.IsOnline.listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

import x1337x.IsOnline.IsOnline;
import x1337x.IsOnline.Friends.LoadData;

public class pListener extends PlayerListener {
    IsOnline plugin;
    LoadData data;
	public pListener(IsOnline i,LoadData d){
		this.plugin = i;
		this.data = d;
		
	}
	
	public void onPlayerJoin(PlayerJoinEvent event){
		data.Load(event.getPlayer());
	}
}
