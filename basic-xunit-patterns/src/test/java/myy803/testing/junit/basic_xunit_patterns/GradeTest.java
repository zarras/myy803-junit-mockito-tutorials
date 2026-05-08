package myy803.testing.junit.basic_xunit_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

	// Constructor test for sanity tests
    @Test
    void constructorInitializesCorrectly() {
        Grade grade = new Grade(20);

        assertEquals(20, grade.getValue());
    }
    
    // Simple success test addBonus
    @Test
    void addBonusReturnsCorrectResult() {
        Grade grade = new Grade(20);

        int result = grade.addBonus(5);

        assertEquals(25, result);
    }

    // Simple success test scaleDown
    @Test
    void scaleDownReturnsCorrectResult() {
        Grade grade = new Grade(20);
        
        assertEquals(10, grade.scaleDown(2));

    }
    
    // Expected exception test (method)
    @Test
    void scaleDownThrowsException() {
        Grade grade = new Grade(20);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            grade.scaleDown(0);
        });

        assertEquals("Cannot divide by zero", ex.getMessage());
    }
    
    // Simple success test scaleUp
    @Test
    void scaleUpReturnsCorrectResult() {
        Grade grade = new Grade(10);
        
        assertEquals(20, grade.scaleUp(2));

    }
}
