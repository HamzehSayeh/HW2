package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT) // Enable parallel execution
class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting Calculator tests...");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Finished Calculator tests.");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup complete.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test complete.");
    }

    @Test
    //@Order(1)
    @DisplayName("Test addition")
    void testAdd() {
        assertEquals(15, calculator.add(5, 5, 5));
    }

    @Test
    @DisplayName("Test division with normal and exceptional cases")
    void testDivide() {
        // Test normal cases
        assertEquals(5, calculator.divide(10, 2));
        assertEquals(2, calculator.divide(6, 3));
        
        // Test edge case: division by 1
        assertEquals(10, calculator.divide(10, 1));

        // Test exception case (divide by zero)
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @Disabled("Fix: Expected result should be 1")
    @DisplayName("Intentional failure test")
    void testFactorialFailure() {
        assertEquals(1, calculator.factorial(0)); // Incorrect expectation
    }
}
