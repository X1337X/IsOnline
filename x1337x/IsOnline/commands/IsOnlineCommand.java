package x1337x.IsOnline.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import x1337x.IsOnline.IsOnline;

public class IsOnlineCommand implements CommandExecutor {
    static IsOnline plugin;
    public IsOnlineCommand(IsOnline plugin){
    	IsOnlineCommand.plugin = plugin;
    }
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		int length = arg3.length;
		if(length == 0 || length > 1){
			arg0.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.RED + "Usage is /isonline playername");
		}
		else if(length == 1){
			String name = arg3[0];
			
		
		
				if(online(name)){
					arg0.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.GREEN + " Player " + name + " is online!");
				}
				else if(!online(name)){
					arg0.sendMessage(ChatColor.YELLOW + "IsOnline : " + ChatColor.RED + " Player " + name + " is not online!");
				}
			}
		
		
		return true;
	
}
public static boolean online(String name){
	for(Player p : plugin.getServer().getOnlinePlayers()){
		String pname = p.getDisplayName();
		if(pname.equalsIgnoreCase(name)){
			return true;
		}
		
	}
	return false;
}


}
