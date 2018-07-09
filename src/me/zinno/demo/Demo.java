package me.zinno.demo;

import me.zinno.demo.commands.SlowChat;
import me.zinno.demo.events.chat.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Demo extends JavaPlugin {
	
	@Override
	public void onEnable() {
		registerEvents();
		registerCommands();
	}
	
	@Override
	public void onDisable() {}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ChatManager(), this);
	}
	
	private void registerCommands() {
		getCommand("slowChat").setExecutor(new SlowChat());
	}
	
}
