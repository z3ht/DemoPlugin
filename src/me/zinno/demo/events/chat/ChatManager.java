package me.zinno.demo.events.chat;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChatManager implements Listener {
	
	private static final long DELAY = 10000000; // milliseconds
	
	private static Map<UUID, Long> spokenPlayers = new HashMap<>();
	public static boolean isSlowChatEnabled = true;
	
	@EventHandler
	public void asyncPlayerChatEvent(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if (player.isOp() && player.hasPermission("chat.admin"))
			return;
		if (isSlowChatEnabled) {
			if (spokenPlayers.containsKey(player.getUniqueId())) {
				if (spokenPlayers.get(player.getUniqueId()) + DELAY > System.currentTimeMillis()) {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a Chat Slow Enabled Please Wait"));
				} else {
					spokenPlayers.remove(player.getUniqueId());
				}
			} else {
				spokenPlayers.put(player.getUniqueId(), System.currentTimeMillis());
				Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Added!");
			}
		}
	}
	
}
