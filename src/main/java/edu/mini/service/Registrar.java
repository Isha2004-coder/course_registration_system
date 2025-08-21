package edu.mini.service;

import edu.mini.domain.*;

import java.util.*;

public class Registrar {
  private final Map<Integer, Student> students = new HashMap<>();
  private final Map<Integer, Course>  courses  = new HashMap<>();
  private final Map<Integer, Set<Integer>> enrollments = new HashMap<>(); 

  public Registrar() {
    // sample
    students.put(1, new Student(1, "Ariana Grande", true));
    students.put(2, new Student(2, "Selena Bardi", false));
    students.put(3, new Student(3, "River Fisher", true));
    students.put(4, new Student(4, "Ivy Rose", false));

    courses.put(10, new LectureCourse(10, "CS101",  "Intro to CS",        3));
    courses.put(11, new LabCourse    (11, "CS101L", "Intro to CS Lab",    2));
    courses.put(12, new LectureCourse(12, "CS310",  "Into to Data Structures and Alorightms",     2));
  }

  public Collection<Student> listStudents(){ return students.values(); }
  public Collection<Course>  listCourses(){  return courses.values();  }

  public String enroll(int studentId, int courseId) {
    Student s = students.get(studentId);
    Course  c = courses.get(courseId);
    if (s == null || c == null) return "Invalid student or course!";

    Set<Integer> roster = enrollments.computeIfAbsent(courseId, k -> new HashSet<>());
    if (roster.contains(studentId)) return "Already enrolled!";
    int currentCount = roster.size();

    if (!c.canEnroll(s, currentCount)) {
      if (currentCount >= c.getCapacity()) return "Course is full!";
      return "Not eligible (needs to complete safety training).";
    }

    roster.add(studentId);
    return "Enrolled " + s.getName() + " in " + c.getCode();
  }

  public List<String> rosterNames(int courseId) {
    Set<Integer> roster = enrollments.getOrDefault(courseId, Set.of());
    List<String> names = new ArrayList<>();
    for (int sid : roster) names.add(students.get(sid).getName());
    names.sort(String::compareTo);
    return names;
  }
}
