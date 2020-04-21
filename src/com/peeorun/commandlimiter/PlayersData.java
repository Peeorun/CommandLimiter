package com.peeorun.commandlimiter;


import java.util.List;


public class PlayersData
{
  List<PlayerStatus> playersStatus;


  public PlayersData()
  {
  }

  public PlayersData( final List<PlayerStatus> playersStatus )
  {
    this.playersStatus = playersStatus;
  }

  public List<PlayerStatus> getPlayersStatus()
  {
    return playersStatus;
  }

  public void setPlayersStatus( final List<PlayerStatus> playersStatus )
  {
    this.playersStatus = playersStatus;
  }
}
