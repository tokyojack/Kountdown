package package;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class StartingCountdown extends Kountdown {

	public StartingCountdown(int countdown, JavaPlugin plugin) {
		super(countdown, plugin);

	}

	@Override
	public void tick(int timeLeft) {
		Bukkit.broadcastMessage("Time left: " + timeLeft);
	}

	@Override
	public void finished() {
		Bukkit.broadcastMessage("Done!");
		//Code to start game...
	}
}
