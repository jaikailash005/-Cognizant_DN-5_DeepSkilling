package com.exmple;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestExample {
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    void testEvenNumbers(int num) {
        assertTrue(num % 2 == 0);
    }
}