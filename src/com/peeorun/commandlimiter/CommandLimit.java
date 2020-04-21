package com.peeorun.commandlimiter;


import java.util.List;


public class CommandLimit
{
  String command;

  List<GroupLimit> groups;


  public CommandLimit()
  {
  }

  public CommandLimit( final String command, final List<GroupLimit> groups )
  {
    this.command = command;
    this.groups = groups;
  }

  public String getCommand()
  {
    return command;
  }

  public void setCommand( final String command )
  {
    this.command = command;
  }

  public List<GroupLimit> getGroups()
  {
    return groups;
  }

  public void setGroups( final List<GroupLimit> groups )
  {
    this.groups = groups;
  }

  public String print()
  {
    StringBuilder elements = new StringBuilder();

    groups.forEach( (GroupLimit g) -> { elements.append( g.name ); elements.append( " " ); elements.append( g.limit ); elements.append( ", " ); } );

    return command + " : " + elements.toString();
  }

}