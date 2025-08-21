package edu.mini.domain;

public class LabCourse extends Course {
  public LabCourse(int id, String code, String title, int capacity) {
    super(id, code, title, capacity);
  }

  @Override
  public boolean canEnroll(Student s, int currentCount) {
    return super.canEnroll(s, currentCount) && s.isSafetyTrained();
  }

  @Override public String toString(){ return super.toString() + " (Lab)"; }
}
