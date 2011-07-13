package x1337x.IsOnline.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import x1337x.IsOnline.IsOnline;
import x1337x.IsOnline.Friends.FriendsList;

public class FriendsCommand implements CommandExecutor {
IsOnline plugin;
public FriendsCommand(IsOnline arg){
	this.plugin = arg;
}
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
     
        FriendsList f = plugin.getList((Player) arg0);
		Player p = (Player) arg0;
		if(f == null){
			
			f = new FriendsList(p.getDisplayName(),this.plugin);
			plugin.lists.add(f);
		}
		if(arg3.length == 0 || arg3.length > 2 ){
			arg0.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.RED + "Usage is /friend add/remove/send playername/message");
			return true;
		}
		if(arg3.length == 2){
			
			if(arg3[0].equalsIgnoreCase("add")){
				
				
				
				f.addFriend(arg3[1]);
				arg0.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.GREEN + "Added " + arg3[1] + " to your friends list!");
				
			}
			else if(arg3[0].equalsIgnoreCase("Remove")){
			
				f.removeFriend(arg3[1]);
				arg0.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.RED + "Removed " + arg3[1] + " from your friends list!");
			}
			
			if(arg3[0].equalsIgnoreCase("send")){
				f.sendMessage(arg3[1]);
				arg0.sendMessage("Message sent to all online friends");
			}
		}
		if(arg3.length == 1){
			if(arg3[0].equalsIgnoreCase("list")){
				arg0.sendMessage(f.getWholeList());
				
			}
			else if(arg3[0].equalsIgnoreCase("online")){
				arg0.sendMessage(f.getOnlinePlayers());
			}
		}
		return true;
	}

}
