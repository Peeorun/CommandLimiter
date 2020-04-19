package com.peeorun.commandlimiter;


import org.bukkit.plugin.java.JavaPlugin;

public class CommandLimiter extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        getLogger().info("CommandLimiter has been enabled!");
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable()
    {
        getLogger().info("CommandLimiter has beeen disabled!");
    }
}

