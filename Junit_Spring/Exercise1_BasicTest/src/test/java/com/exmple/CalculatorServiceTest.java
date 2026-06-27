package com.exmple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private CalculatorService service = new CalculatorService();
    @Test
    void testAdd() {
        int result = service.add(2, 3);
        assertEquals(5, result);
    }
}