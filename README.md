# Student Course Registration System

A Java application for managing student course enrollment, built to demonstrate object-oriented design principles including inheritance, polymorphism, and encapsulation.

## Features

- Swing-based user interface using JList, JButton, and JTextArea
- Course capacity validation
- Duplicate enrollment prevention
- Polymorphic enrollment rules for lab courses requiring safety training
- Object-oriented domain model for students and course types
- **Entry point:** `edu.mini.app.Main`

## Run
```bash
mvn -q clean package
mvn -q exec:java
