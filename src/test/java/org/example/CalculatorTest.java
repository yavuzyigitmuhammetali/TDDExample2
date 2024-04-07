

// Student number: B211202060
// First name and last name: Muhammet Ali Yavuzyiğit
// Course name and homework Info: SWE 202 SOFTWARE VERIFICATION AND VALIDATION - HOMEWORK 1
// GitHub repository address: https://github.com/yavuzyigitmuhammetali/TDDExample2






package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    static Stream<Arguments> divisionTestCases() {
        return Stream.of(
            Arguments.of(10, 2, 5),
            Arguments.of(10, 4, 2.5),
            Arguments.of(12.5f, 2.5f, 5),
            Arguments.of(10, 2.5f, 4),
            Arguments.of(12.5f, 5, 2.5f)
        );
    }

    @ParameterizedTest
    @MethodSource("divisionTestCases")
    void testDivision(float a, float b, double expected) {
        assertEquals(expected, Calculator.divide(a, b));
    }

    @Test
    void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }
}