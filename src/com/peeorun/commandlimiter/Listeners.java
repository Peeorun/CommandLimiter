package com.peeorun.commandlimiter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.yaml.snakeyaml.constructor.Constructor;


public class Listeners implements Listener
{
    public static int playerCommandLimit = 10;
    public static String pluginPrefix = ChatColor.RED + "[CommandLimiter] ";
    public static ArrayList<PlayerStatus> playersData;


    @EventHandler
    public void onPreCommand( PlayerCommandPreprocessEvent event ) {
        Player player = event.getPlayer();

        try
        {
            Yaml yaml = new Yaml( new Constructor( Config.class ) );
            Config config = yaml.loadAs( new FileInputStream( new File( CommandLimiter.userDir + "/plugins/config.yaml" ) ), Config.class );

            for(CommandLimit limitedCommands : config.limitedCommands
            )
            {
                if ( event.getMessage().toLowerCase().startsWith( limitedCommands.command ) )
                {
                    for( GroupLimit groupLimit : limitedCommands.groups
                     )
                    {
                        long count = playersData.stream()
                          .filter(p -> p.player.equals( player.getName() ) && p.command.equals( limitedCommands.command )).count();
                        if ( player.hasPermission( groupLimit.name ) )
                        {
                            if ( count != groupLimit.limit )
                            {
                                long currentTimestamp = ZonedDateTime.now().toInstant().toEpochMilli();
                                playersData.add(new PlayerStatus(limitedCommands.command, currentTimestamp, player.getName()));
                                player.sendMessage( pluginPrefix + ChatColor.GOLD + "You have " + (groupLimit.limit - count) + " uses left!" );
                            }else
                                {
                                    player.sendMessage( pluginPrefix + ChatColor.RED + "You don't have any uses left" );
                                }
                        }
                    }
                }

            }

            System.out.println( config );
            //config.limitedCommands.forEach( (CommandLimit cl) -> { System.out.println( cl.print() ); } );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

//        if (event.getMessage().toLowerCase().startsWith("/tpa")) {
//            if (playerCommandLimit > 0) {
//                playerCommandLimit--;
//                player.sendMessage(pluginPrefix + ChatColor.GOLD + "You have " + playerCommandLimit + " left teleports.");
//            } else {
//                player.sendMessage(pluginPrefix + ChatColor.GOLD + "You don't have any teleports left.");
//                event.setCancelled(true);
//            }
//        }
    }
}
