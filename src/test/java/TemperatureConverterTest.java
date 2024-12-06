import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {


    @ParameterizedTest
    @CsvSource({
            "0,32",
            "25,77",
            "-40,-40",
    })
    void testCelsiusToFahrenheit(
            double celsius, double fahrenheit
    ) {
        assertEquals(fahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius));
    }

    @Test
    void testCelsiusToFahrenheitThrowsExceptionWhenBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> TemperatureConverter.celsiusToFahrenheit(-274));
    }



}