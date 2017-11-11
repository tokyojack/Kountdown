package package;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Test1 extends JavaPlugin implements Listener {

	Kountdown gameStart = new Kountdown(this) {

		@Override
		public void tick(Player player, int countdown) {
			player.sendMessage("Time left: " + countdown);

		}

		@Override
		public void finished(Player player) {
			player.sendMessage("Game started!");
			//Code to start game...
		}

	};

	Kountdown gameStart1 = new Test2(this);

	public void onEnable() {
		PluginManager pluginManager = getServer().getPluginManager();
		pluginManager.registerEvents(this, this);
	}

	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		// if some condition...
		this.gameStart.start();
		//OR
		this.gameStart1.start();
	}

}

