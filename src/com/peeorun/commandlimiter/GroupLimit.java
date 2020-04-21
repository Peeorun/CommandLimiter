package com.peeorun.commandlimiter;


public class GroupLimit
{
  /**
   * Group permission
   */
  String name;

  /**
   * Time in seconds
   */
  int time;

  /**
   * Limit commands within 'time'
   */
  int limit;


  public GroupLimit()
  {
  }

  public GroupLimit( final String name, final int limit, final int time )
  {
    this.name = name;
    this.limit = limit;
    this.time = time;
  }

  public int getTime()
  {
    return time;
  }

  public void setTime( final int time )
  {
    this.time = time;
  }

  public int getLimit()
  {
    return limit;
  }

  public void setLimit( final int limit )
  {
    this.limit = limit;
  }

  public String getName()
  {
    return name;
  }

  public void setName( final String name )
  {
    this.name = name;
  }
}
