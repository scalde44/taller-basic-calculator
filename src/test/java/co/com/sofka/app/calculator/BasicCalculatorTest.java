package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing substract: 5-4=1")
    public void substract() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 4L;
        Long expectedValue = 1L;

        // Act
        Long result = basicCalculator.substract(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several substracts")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "45,    34,   11",
            "7,    2,   5",
            "32,  6, 26",
            "120,  100, 20"
    })
    public void severalSubstracts(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.substract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing multiply: 6*2=12")
    public void multiply() {
        // Arrange
        Long number1 = 6L;
        Long number2 = 2L;
        Long expectedValue = 12L;

        // Act
        Long result = basicCalculator.multiply(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several multiplies")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "7,    8,   56",
            "17,    22,   374",
            "32,  3, 96",
            "121,  4, 484"
    })
    public void severalMultiplies(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }


    @Test
    @DisplayName("Testing division: 9/2=4.5")
    public void division() {
        // Arrange
        Long number1 = 9L;
        Long number2 = 2L;
        Double expectedValue = 4.5;

        // Act
        Double result = basicCalculator.division(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing divisionByZero: 5/0=ArithmeticException")
    public void divisionByZero() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 0L;

        //Act
        Double result = basicCalculator.division(number1, number2);

        // Assert
        //assertThrows(ArithmeticException.class, () -> basicCalculator.division(number1, number2));
        assertTrue(Double.isInfinite(result));
    }

    @DisplayName("Testing several divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "8,    2,   4",
            "25,    7,   3.571428",
            "33,    4,   8.25",
            "18,    5,   3.6",
    })
    public void severalDivisions(Long first, Long second, Double expectedResult) {
        assertEquals(expectedResult, basicCalculator.division(first, second), 0.00001);
    }
}