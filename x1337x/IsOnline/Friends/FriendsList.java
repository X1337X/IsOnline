package x1337x.IsOnline.Friends;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import x1337x.IsOnline.IsOnline;
import x1337x.IsOnline.commands.IsOnlineCommand;

public class FriendsList {

	ArrayList<String> friends = new ArrayList<String>();
	String owner = null;
	IsOnline plugin;
	public FriendsList(String owner,IsOnline pl){
		this.owner = owner;
		this.plugin = pl;
	}
	
	public void addFriend(String friend){
		this.friends.add(friend);
	}
	public void removeFriend(String friend){
		this.friends.remove(friend);
	}
	public ArrayList<String> getRawList(){
		return friends;
	}
	public String getWholeList(){
		String pre = ChatColor.YELLOW +  "IsOnline : " + ChatColor.GOLD + "Friends : ";
		String friends = " ";
		int pos = 0;
		int size = this.friends.size();
		while(pos != size){
			String friend = this.friends.get(pos);
			if(IsOnlineCommand.online(friend)){
			friends += ChatColor.GREEN + friend + ",";
			}
			else if(!IsOnlineCommand.online(friend)){
				friends += ChatColor.RED + friend + ",";
			}
			pos++;
		}
		return pre + friends;
		
	}
	public String getOnlinePlayers(){
		String pre = ChatColor.YELLOW +  "IsOnline : " + ChatColor.GOLD + "Friends Online : ";
		String friends = "";
		int pos = 0;
		int size = this.friends.size();
		while(pos != size){
			String friend = this.friends.get(pos);
			if(IsOnlineCommand.online(friend)){
			friends +=  ChatColor.GREEN + friend + "," ;
			}
			pos++;
		}
		return pre + friends;
		
	}
	public String getOwner(){
		return this.owner;
	}
	public void sendMessage(String message){
		int pos = 0;
	    int size = this.friends.size();
	    
		while(pos != size){
			String s = this.friends.get(pos);
			
			if(IsOnlineCommand.online(s)){
				Player p = this.plugin.getServer().getPlayer(s);
				p.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.BLUE + this.getOwner() + " : "  + ChatColor.GOLD + message);
			}
			pos++;
		}
		
	}

}
