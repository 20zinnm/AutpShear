package autoshear;

import org.bukkit.plugin.java.JavaPlugin;

public class AutpShear extends JavaPlugin {

	public void onEnable() {
		getLogger().info("AutoShear enabled!");
		AutoShearListener asl = new AutoShearListener();
		getServer().getPluginManager().registerEvents(asl, this);
	}
	public void onDisable() {
		getLogger().info("AutoShear disabled!");
	}
	
}
