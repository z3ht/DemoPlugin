package me.zinno.demo.commands;

import me.zinno.demo.events.chat.ChatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SlowChat implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ChatManager.isSlowChatEnabled = !ChatManager.isSlowChatEnabled;
		return true;
	}

}
