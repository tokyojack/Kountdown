package package;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Kountdown {

	private int timeLeft;
	private int seconds;
	private int runnableID;

	private int ORGINAL_TIME;
	private JavaPlugin plugin;

	public Kountdown(int timeLeft, JavaPlugin plugin) {
		this(timeLeft, 1, plugin);
	}

	public Kountdown(int timeLeft, int seconds, JavaPlugin plugin) {
		this.timeLeft = timeLeft;
		this.seconds = seconds;
		this.runnableID = 0;

		this.ORGINAL_TIME = timeLeft;
		this.plugin = plugin;
	}

	public abstract void tick(int timeLeft);

	public abstract void finished();

	public void start() {
		runnableID = this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			public void run() {

				// If there is no time left
				if (timeLeft <= 0) {
					finished(); // Runs the abstract void "finished"
					stop(); // Stops the runnable
					return; // Returns just in case
				}

				// Runs the abstract void "tick"
				tick(timeLeft);
				
				// Subtracts the time by 1
				timeLeft--;
			}
		}, 0, this.seconds * 20);

	}

	/**
	 * Stops the runnable
	 */
	public void stop() {
		resetTimeLeft();
		Bukkit.getScheduler().cancelTask(this.runnableID);
	}

	/**
	 * Resets the runnable's time
	 */
	public void resetTimeLeft() {
		this.timeLeft = this.ORGINAL_TIME;
	}

}