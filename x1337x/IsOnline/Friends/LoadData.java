package x1337x.IsOnline.Friends;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.bukkit.entity.Player;

import x1337x.IsOnline.IsOnline;

public class LoadData {

	
	IsOnline plugin;
	public LoadData(IsOnline arg){
		this.plugin = arg;
	}
public void Load(Player player){	
	String name = player.getDisplayName();
	String loc = "plugins" + File.separator + "isonline" + File.separator + "FriendsList storage" + File.separator;
	String filename = name + ".txt";
	File file = new File(loc + filename);
	FriendsList list = new FriendsList(name,plugin);
	
	Scanner scanner;
	try {
		scanner = new Scanner(file);
		 while (scanner.hasNextLine()) {
		      String line = scanner.nextLine();
		      list.addFriend(line);
		    }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		player.sendMessage("You have no friends list - use /friend add playername to make one");
	}
	
	plugin.lists.add(list);
	
   player.sendMessage("Loaded your friends list!");
}
}
