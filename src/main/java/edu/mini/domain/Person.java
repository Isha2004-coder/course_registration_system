package edu.mini.domain;

public abstract class Person {
  protected final int id;
  protected final String name;

  protected Person(int id, String name) {
    this.id = id;
    this.name = name;
  }
  public int getId(){ return id; }
  public String getName(){ return name; }

  @Override public String toString(){ return id + " - " + name; }
}
