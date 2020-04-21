package com.peeorun.commandlimiter;

import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class CommandLimiter extends JavaPlugin
{
    public static String userDir = System.getProperty( "user.dir" );


    @Override
    public void onEnable()
    {
        GroupLimit gl1 = new GroupLimit( "default", 10, 10 );
        GroupLimit gl2 = new GroupLimit( "vip", 15, 10 );

        List<GroupLimit> gLimits1 = new ArrayList<>();
        gLimits1.add( gl1 );
        gLimits1.add( gl2 );
        CommandLimit cm1 = new CommandLimit( "tpa", gLimits1 );
        List<CommandLimit> cLimits = new ArrayList<>();
        cLimits.add( cm1 );

        Config config = new Config(cLimits);

        try
        {
            Representer representer = new Representer();
            representer.addClassTag( Config.class, Tag.MAP );

            Yaml yaml = new Yaml( representer, new DumperOptions() );

            FileWriter writer = new FileWriter(userDir + "/plugins/config.yaml");
            yaml.dump( config, writer );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        getLogger().info("CommandLimiter has been enabled!");
        getServer().getPluginManager().registerEvents( new Listeners(), this );
    }

    @Override
    public void onDisable()
    {
        getLogger().info("CommandLimiter has been disabled!");
    }
}

