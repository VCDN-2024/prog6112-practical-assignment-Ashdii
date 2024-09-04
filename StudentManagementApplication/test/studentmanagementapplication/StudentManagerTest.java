package studentmanagementapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {

    private StudentManager studentManager;

    @BeforeEach
    void setUp() {
        studentManager = new StudentManager();
    }

    @Test
    void TestSaveStudent() {
        // Arrange
        String id = "123";

        // Act
        studentManager.SaveStudent(id, null, 0, null, null);

        // Assert
        StudentManager.Student savedStudent = studentManager.SearchStudent(id);
        assertNotNull(savedStudent, "Student should be saved and not null.");
        assertEquals(id, savedStudent.getId(), "Student ID should match.");
    }

    @Test
    void TestSearchStudent() {
        // Arrange
        String id = "123";
        studentManager.SaveStudent(id, null, 0, null, null);

        // Act
        StudentManager.Student student = studentManager.SearchStudent(id);

        // Assert
        assertNotNull(student, "Student should be found.");
        assertEquals(id, student.getId(), "Student ID should match.");
    }

    @Test
    void TestSearchStudent_StudentNotFound() {
        // Arrange
        String id = "999"; // Non-existent ID

        // Act
        StudentManager.Student student = studentManager.SearchStudent(id);

        // Assert
        assertNull(student, "Student should not be found.");
    }

    @Test
    void TestDeleteStudent() {
        // Arrange
        String id = "123";
        studentManager.SaveStudent(id, null, 0, null, null);

        // Act
        boolean isDeleted = studentManager.DeleteStudent(id);

        // Assert
        assertTrue(isDeleted, "Student should be successfully deleted.");
        assertNull(studentManager.SearchStudent(id), "Deleted student should not be found.");
    }

    @Test
    void TestDeleteStudent_StudentNotFound() {
        // Arrange
        String id = "999"; // Non-existent ID

        // Act
        boolean isDeleted = studentManager.DeleteStudent(id);

        // Assert
        assertFalse(isDeleted, "Deletion should fail since student does not exist.");
    }

    @Test
    void TestStudentAge_StudentAgeValid() {
        // Arrange
        int age = 18;

        // Act
        boolean isValid = studentManager.isValidAge(age);

        // Assert
        assertTrue(isValid, "Age should be valid.");
    }

    @Test
    void TestStudentAge_StudentAgeInvalid() {
        // Arrange
        int age = 15;

        // Act
        boolean isValid = studentManager.isValidAge(age);

        // Assert
        assertFalse(isValid, "Age should be invalid (less than 16).");
    }

    @Test
    void TestStudentAge_StudentAgeInvalidCharacter() {
        // Arrange
        String ageInput = "abc";

        // Act & Assert
        assertThrows(NumberFormatException.class, () -> {
            int age = Integer.parseInt(ageInput);
            studentManager.isValidAge(age);
        }, "Should throw NumberFormatException for invalid characters.");
    }
}