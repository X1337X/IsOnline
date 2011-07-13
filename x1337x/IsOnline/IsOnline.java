package x1337x.IsOnline;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;

import x1337x.IsOnline.Friends.FriendsList;
import x1337x.IsOnline.Friends.LoadData;
import x1337x.IsOnline.Friends.SaveData;
import x1337x.IsOnline.commands.FriendsCommand;
import x1337x.IsOnline.commands.IsOnlineCommand;
import x1337x.IsOnline.listener.pListener;

public class IsOnline extends JavaPlugin {
	public ArrayList<FriendsList> lists = new ArrayList<FriendsList>();
	public LoadData data = new LoadData(this);
    public FriendsCommand f = new FriendsCommand(this);
	public pListener p = new pListener(this, data);
	 IsOnlineCommand command = new IsOnlineCommand(this);
	 SaveData sdata = new SaveData(this);
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		sdata.saveFriends();
		int size = lists.size();
		size++;
		this.getServer().getLogger().log(Level.INFO,"saved " + size + " friend lists");
		this.getServer().getLogger().log(Level.INFO, "IsOnline is disabled!");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
        this.getServer().getPluginManager().registerEvent(Type.PLAYER_JOIN, p, Priority.Highest, this);
		this.getServer().getLogger().log(Level.INFO, "IsOnline is enabled!");
		this.getCommand("isonline").setExecutor(command);
		this.getCommand("io").setExecutor(command);
		this.getCommand("friend").setExecutor(this.f);
		this.getCommand("f").setExecutor(this.f);
	}
	
	public FriendsList getList(Player p){
		int poss = 0;
		int length = this.lists.size();
		while(poss != length){
			FriendsList pn = this.lists.get(poss);
			String name = p.getDisplayName();
			if(pn.getOwner().equalsIgnoreCase(name)){
				return pn;
			}
			poss++;				
		}
		return null;
	}
}
