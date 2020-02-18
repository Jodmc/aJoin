package ga.ankh.aJoin.Events;

import ga.ankh.aJoin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
    private Plugin plugin = Main.getPlugin(Main.class);
    @EventHandler(priority= EventPriority.MONITOR)
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            Server server = plugin.getServer();
            FileConfiguration config = plugin.getConfig();
            String firstJoinBroadcast = config.getString("first-join-broadcast");
            String firstJoinMessage = config.getString("first-join-message");
            String firstJoinCommand = config.getString("first-join-command");
            if (firstJoinBroadcast.length() > 0) {
                String message1 = firstJoinBroadcast.replace("{player}", player.getName());
                String message = ChatColor.translateAlternateColorCodes('&', message1);
                server.broadcastMessage(message);
            }
            if (firstJoinMessage.length() > 0) {
                String message1 = firstJoinMessage.replace("{player}", player.getName());
                String message = ChatColor.translateAlternateColorCodes('&', message1);
                player.sendMessage(message);
            }
            if (firstJoinCommand.length() > 0) {
                String command = firstJoinCommand.replace("{player}", player.getName());
                server.dispatchCommand(server.getConsoleSender(), command);
            }
        }
    }
}
