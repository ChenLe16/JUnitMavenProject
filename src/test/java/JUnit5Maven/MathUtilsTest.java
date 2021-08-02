package JUnit5Maven;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    // in order to use BeforeAll
    // the method has to be set as static as it is independent on the instance created
    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This needs to run before All");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning Up...");
    }

    @Nested
    class AddTest{
        @Test
        @Tag("Math")
        @DisplayName("Testing Add Method for Positive") // display (NAME) instead of method name
        void testAddPositive() {
            assertEquals(3, mathUtils.add(2,1));
        }

        @Test
        @Tag("Math")
        @DisplayName("Testing Add Method for Negative") // display (NAME) instead of method name
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1,-1));
        }
    }

    @Test
    @Tag("Math")
    @EnabledOnOs(OS.MAC)
    void testDivide(){
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(10, 0),
                "Denominator being 0 should throw Exception");
    }

    @Test
    @Tag("Math")
    @DisplayName("Multiply Method")
    void testMultiply(){
       assertAll("Correct Multiplication",
               () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2,0)),
                () -> assertEquals(2, mathUtils.multiply(2,1))
        );
    }


    @Test
    @Tag("Circle")
    void testComputeCircleArea(){
        //given
        double radius = 10;

        // when
        double result = mathUtils.computeCircleArea(radius);

        // then
        int expected = 314;
        assertEquals(expected, (int)result, "The method should return right Area of Circle");
    }
}