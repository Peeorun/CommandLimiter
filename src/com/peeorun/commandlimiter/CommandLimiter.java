package com.peeorun.commandlimiter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandLimiter extends JavaPlugin implements Listener
{
    public static int playerCommandLimit = 10;
    //public static string pluginPrefix = ChatColor.RED + "[CommandLimiter]"();

    @Override
    public void onEnable()
    {
        getLogger().info("CommandLimiter has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable()
    {
        getLogger().info("CommandLimiter has beeen disabled!");
    }
    @EventHandler
    public void onPreCommand(PlayerCommandPreprocessEvent event)
    {
        Player player = event.getPlayer();
        String[] args = event.getMessage().split(" ");
        if (args[0].equalsIgnoreCase("/tpa") && args.length == 1)
        {
            if (playerCommandLimit > 0){
                playerCommandLimit--;
                player.sendMessage("You have "+ playerCommandLimit + " left teleports.");
            }else{
                player.sendMessage( "You don't have any teleports left.");
                event.setCancelled(true);
            }


        }
    }

}

