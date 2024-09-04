package studentmanagementapplication;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void SaveStudent(String id, String name, int age, String email, String course) {
        Student student = new Student(id, name, age, email, course);
        studentList.add(student);
    }

    public Student SearchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean DeleteStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    public boolean isValidAge(int age) {
        return age >= 16;
    }

    public void StudentReport() {
        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students to display.");
        } else {
            StringBuilder report = new StringBuilder("Student Report:\n");
            for (Student student : studentList) {
                report.append("ID: ").append(student.getId())
                      .append(", Name: ").append(student.getName())
                      .append(", Age: ").append(student.getAge())
                      .append(", Email: ").append(student.getEmail())
                      .append(", Course: ").append(student.getCourse())
                      .append("\n");
            }
            JOptionPane.showMessageDialog(null, report.toString());
        }
    }

    public void ExitStudentApplication() {
        JOptionPane.showMessageDialog(null, "Exiting the application...");
    }

    public static class Student {
        private final String id;
        private final String name;
        private final int age;
        private final String email;
        private final String course;

        public Student(String id, String name, int age, String email, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }

        public String getCourse() {
            return course;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Course: " + course;
        }
    }
}
