package studentmanagementapplication;

import javax.swing.JOptionPane;

/**
 * This class represents the main application for managing student records.
 * It allows capturing, searching, deleting students, and displaying a student report.
 */
public class StudentManagementApplication {
    
    // StudentManager object to manage student operations
    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        // Main loop to continuously display the menu and process user input
        while (true) {
            int choice = displayMenu();

            switch (choice) {
                case 1 -> captureStudent(); // Capture a new student
                case 2 -> searchStudent(); // Search for a student by ID
                case 3 -> deleteStudent(); // Delete a student by ID
                case 4 -> studentManager.StudentReport(); // Print the student report
                case 5 -> exitApplication(); // Exit the application
                default -> JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
            }
        }
    }

    /**
     * Displays the main menu and captures the user's choice.
     * @return the user's menu choice as an integer.
     */
    private static int displayMenu() {
        String[] options = {"Capture a new student", "Search for a student", "Delete a student", 
                            "Print student report", "Exit Application"};
        return JOptionPane.showOptionDialog(null, "Please select one of the following menu items:",
                "STUDENT MANAGEMENT APPLICATION",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) + 1;
    }

    /**
     * Captures student details through dialog boxes and saves the student.
     */
    private static void captureStudent() {
        String id = JOptionPane.showInputDialog("Enter the student ID:");
        String name = JOptionPane.showInputDialog("Enter the student name:");

        int age = 0;
        while (true) {
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter the student age:"));
                if (age < 16) {
                    JOptionPane.showMessageDialog(null, "Invalid age! Age must be at least 16.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for age.");
            }
        }

        String email = JOptionPane.showInputDialog("Enter the student email:");
        String course = JOptionPane.showInputDialog("Enter the student course:");

        studentManager.SaveStudent(id, name, age, email, course);
        JOptionPane.showMessageDialog(null, "Student captured successfully!");
    }

    /**
     * Prompts the user for a student ID and searches for the student.
     */
    private static void searchStudent() {
        String id = JOptionPane.showInputDialog("Enter the student ID to search:");
        StudentManager.Student student = studentManager.SearchStudent(id);
        if (student != null) {
            JOptionPane.showMessageDialog(null, "Student Found: " + student);
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!");
        }
    }

    /**
     * Prompts the user for a student ID and deletes the student if found.
     */
    private static void deleteStudent() {
        String id = JOptionPane.showInputDialog("Enter the student ID to delete:");
        boolean success = studentManager.DeleteStudent(id);
        if (success) {
            JOptionPane.showMessageDialog(null, "Student deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!");
        }
    }

    /**
     * Exits the application.
     */
    private static void exitApplication() {
        JOptionPane.showMessageDialog(null, "Exiting the application...");
        System.exit(0);
    }
}

//Reference List

//Book
//Title: Java: The Complete Reference
//Author: Herbert Schildt
//Date: 2018
//Edition: 11th ed
//Publisher: McGraw-Hill Education

//Book
//Title: Effective Java
//Author: Joshua Bloch
//Date: 2018
//Edition: 3rd ed
//Publisher: Addison-Wesley

//Book
//Title: Head First Java
//Authors: Kathy Sierra and Bert Bates
//Date: 2005
//Edition: 2nd ed
//Publisher: O'Reilly Media