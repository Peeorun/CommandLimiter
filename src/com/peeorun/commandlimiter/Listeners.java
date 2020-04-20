package com.peeorun.commandlimiter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class Listeners implements Listener
{
    public static int playerCommandLimit = 10;
    public static String pluginPrefix = ChatColor.RED + "[CommandLimiter] ";


    @EventHandler
    public void onPreCommand( PlayerCommandPreprocessEvent event ) {
        Player player = event.getPlayer();

        if( player.hasPermission( "group.vip" ) )
        {
            player.sendMessage(pluginPrefix + ChatColor.GOLD + "VIP permission enabled!" );
        }


        if (event.getMessage().toLowerCase().startsWith("/tpa")) {
            if (playerCommandLimit > 0) {
                playerCommandLimit--;
                player.sendMessage(pluginPrefix + ChatColor.GOLD + "You have " + playerCommandLimit + " left teleports.");
            } else {
                player.sendMessage(pluginPrefix + ChatColor.GOLD + "You don't have any teleports left.");
                event.setCancelled(true);
            }
        }
    }
}
