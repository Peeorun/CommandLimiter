package com.peeorun.commandlimiter;


public class PlayerStatus
{
  String command;

  long timestamp;

  String player;


  public PlayerStatus()
  {
  }

  public PlayerStatus( final String command, final long timestamp, final String player )
  {
    this.command = command;
    this.timestamp = timestamp;
    this.player = player;
  }

  public String getCommand()
  {
    return command;
  }

  public void setCommand( final String command )
  {
    this.command = command;
  }

  public long getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp( final long timestamp )
  {
    this.timestamp = timestamp;
  }

  public String getPlayer()
  {
    return player;
  }

  public void setPlayer( final String player )
  {
    this.player = player;
  }

  public String print()
  {
    return command + " " + timestamp + " " + player;
  }
}
