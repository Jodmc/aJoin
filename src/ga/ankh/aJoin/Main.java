package ga.ankh.aJoin;

import ga.ankh.aJoin.Events.PlayerJoin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "aJoin Plugin successfully enabled.");
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        // Loads the config.
        loadConfig();
    }
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "aJoin Plugin successfully disabled. Goodbye!");
    }
    public void loadConfig() {
        saveDefaultConfig();
    }
}
