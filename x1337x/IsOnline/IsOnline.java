package x1337x.IsOnline;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import x1337x.IsOnline.commands.IsOnlineCommand;

public class IsOnline extends JavaPlugin {

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		this.getServer().getLogger().log(Level.INFO, "IsOnline is enabled!");
		this.getCommand("isonline").setExecutor(new IsOnlineCommand(this));
	}
}
