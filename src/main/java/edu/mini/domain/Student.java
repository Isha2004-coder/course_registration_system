package edu.mini.domain;

public class Student extends Person {
  private final boolean safetyTrained; // demonstrates encapsulation

  public Student(int id, String name, boolean safetyTrained) {
    super(id, name);
    this.safetyTrained = safetyTrained;
  }

  public boolean isSafetyTrained(){ return safetyTrained; }
}
