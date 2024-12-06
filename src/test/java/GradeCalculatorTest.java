import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "55, F"
    })
    void testGetGrade(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score));
    }

    @Test
    void testGetGradeThrowsExceptionWhenBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(-1));
    }

    @Test
    void testGetGradeThrowsExceptionWhenAboveHundred() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(101));
    }

}