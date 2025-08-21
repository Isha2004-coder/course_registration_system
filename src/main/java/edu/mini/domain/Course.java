package edu.mini.domain;

public abstract class Course {
  protected final int id;
  protected final String code;
  protected final String title;
  protected final int capacity;

  protected Course(int id, String code, String title, int capacity) {
  this.id = id; this.code = code; this.title = title; this.capacity = capacity;
  } // protected is used so that LectureCourse and LabCourse could access it

  public int getId()
  { return id; }
  public String getCode()
  { return code; }
  public String getTitle()
  { return title; }
  public int getCapacity()
  { return capacity; }

  public boolean canEnroll(Student s, int currentCount) {
    return currentCount < capacity;
  }

  @Override public String toString(){ return id + " - " + code + " — " + title; }
}
