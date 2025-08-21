package edu.mini.MainWindow;
import edu.mini.domain.Course;
import edu.mini.domain.Student;
import edu.mini.service.Registrar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ui extends JFrame  {
    
    private final Registrar registrar = new Registrar();

  
  private final DefaultListModel<Student> studentModel = new DefaultListModel<>();
  private final JList<Student> studentList = new JList<>(studentModel);

  private final DefaultListModel<Course> courseModel = new DefaultListModel<>();
  private final JList<Course> courseList = new JList<>(courseModel);

  private final JTextArea output = new JTextArea(8, 50);
  private final JButton enrollBtn = new JButton("Enroll");
  private final JButton rosterBtn = new JButton("View Roster");

  public ui() {
    super("Course Registration");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(10,10));

    // students
    JPanel left = new JPanel(new BorderLayout());
    left.add(new JLabel("Students"), BorderLayout.NORTH);
    studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    left.add(new JScrollPane(studentList), BorderLayout.CENTER);

    // courses
    JPanel right = new JPanel(new BorderLayout());
    right.add(new JLabel("Courses"), BorderLayout.NORTH);
    courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    right.add(new JScrollPane(courseList), BorderLayout.CENTER);

    // actions
    JPanel center = new JPanel(new GridLayout(2,1,6,6));
    center.add(enrollBtn);
    center.add(rosterBtn);

    // output
    output.setEditable(false);
    add(left, BorderLayout.WEST);
    add(center, BorderLayout.CENTER);
    add(right, BorderLayout.EAST);
    add(new JScrollPane(output), BorderLayout.SOUTH);

    pack();
    setLocationRelativeTo(null);

    refreshLists();

 
    enrollBtn.addActionListener(e -> onEnroll());
    rosterBtn.addActionListener(e -> onRoster());
  }

  private void refreshLists() {
    studentModel.clear();
    courseModel.clear();
    for (Student s : registrar.listStudents()) studentModel.addElement(s);
    for (Course c : registrar.listCourses())  courseModel.addElement(c);
  }

  private void onEnroll() {
    Student s = studentList.getSelectedValue();
    Course  c = courseList.getSelectedValue();
    if (s == null || c == null) {
      println("Select a student and a course first.");
      return;
    }
    String msg = registrar.enroll(s.getId(), c.getId());
    println(msg);
  }

  private void onRoster() {
    Course c = courseList.getSelectedValue();
    if (c == null) {
      println("Select a course first.");
      return;
    }
    List<String> names = new ArrayList<>(registrar.rosterNames(c.getId()));
    println("Roster for " + c.getCode() + ": " + names);
  }

  private void println(String s) {
    output.append(s + "\n");
    output.setCaretPosition(output.getDocument().getLength());
  }
}
