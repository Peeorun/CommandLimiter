package com.peeorun.commandlimiter;


import java.util.List;


public class Config
{
  List<CommandLimit> limitedCommands;


  public Config() {}

  public Config( final List<CommandLimit> limitedCommands )
  {
    this.limitedCommands = limitedCommands;
  }

  public List<CommandLimit> getLimitedCommands()
  {
    return limitedCommands;
  }

  public void setLimitedCommands( final List<CommandLimit> limitedCommands )
  {
    this.limitedCommands = limitedCommands;
  }
}
