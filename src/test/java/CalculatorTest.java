import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdditionReturnCorrectValue(){
        int result = Calculator.add(1, 2);
        assertEquals(3, result);
        assertNotEquals(4, result);
    }

    @Test
    void testGreetingReturnNullWhenNameIsEmpty(){
        String result = Calculator.getGreeting("");
        assertNull(result);
    }

    @Test
    void testGreetingReturnCorrectValue(){
        String result = Calculator.getGreeting("Rana");
        assertNotNull(result);
        assertEquals("Hello, Rana!", result);
    }

    @Test
    void testDivisionByZeroThrowsException(){
        assertThrows(ArithmeticException.class, () -> Calculator.divide(1, 0));
    }

    @Test
    void testDivisionByNonZeroReturnCorrectValue(){
        int result = Calculator.divide(4, 2);
        assertDoesNotThrow(() -> Calculator.divide(4, 2));
        assertEquals(2, result);
    }

    @Test
    void testTwoArraysAreEqual(){
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        assertArrayEquals(array1, array2);
    }

    @Test
    void testTwoObjetsAreSame(){
        String s1=new String("Rana");
        String s2=s1;
        assertSame(s1, s2);
    }

    @Test
    void testLinesMatch(){
        List<String> list1 = List.of("line1", "line2", "line3");
        List<String> list2 = List.of("line1", "line2", "line3");
        assertLinesMatch(
            list1,
            list2
        );
    }

    @Test
    void testTimeOut(){
        assertTimeout(
            Duration.ofMillis(100),
            () -> {
                Calculator.add(1, 2);
            }
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "2, 3, 5",
        "3, 4, 7"
    })
    void testAdditionReturnCorrectValue(int a, int b, int result){
        assertEquals(result, Calculator.add(a, b));
    }

    @RepeatedTest(5)
    void testGenerateRandomNumberReturnCorrectValue(){
        int result = Calculator.generateRandomNumber(1, 10);
        assertTrue(result >= 1 && result <= 10);
    }

}