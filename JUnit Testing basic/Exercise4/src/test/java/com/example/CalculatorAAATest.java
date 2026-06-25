package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorAAATest {
    private Calculator calc;
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup executed");
    }
    @Test
    public void testAdd() {
        // 1-(A) -> Arrange
        int a = 2;
        int b = 3;
        // 2-(A) -> Act
        int result = calc.add(a, b);
        // 3-(A) -> Assert
        assertEquals(5, result);
    }
    @After
    public void tearDown() {
        calc = null;
        System.out.println("Teardown executed");
    }
}