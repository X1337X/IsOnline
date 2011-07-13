package x1337x.IsOnline.Friends;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import x1337x.IsOnline.IsOnline;

public class SaveData {
	String fileloc = "plugins" + File.separator + "isonline" + File.separator + "FriendsList storage" + File.separator;
IsOnline plugin;
public SaveData(IsOnline arg){
	this.plugin = arg;
}

public void saveFriends(){
	ArrayList<FriendsList> local = plugin.lists;
	int pos = 0;
	int size = local.size();
	while(pos != size){
		FriendsList list = local.get(pos);
		String file = list.owner.toLowerCase() + ".txt";
		File dir = new File(fileloc);
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		File whole = new File(this.fileloc + file);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(whole));
			int poss = 0;
			int length = list.friends.size();
			while(poss != length){
				String p = list.friends.get(poss);
				String name = p;
				writer.write(name);
				writer.newLine();
				poss++;				
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pos++;
	}
	
}
}
