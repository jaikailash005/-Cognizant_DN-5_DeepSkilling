package com.example;
import static org.junit.Assert.*;
import org.junit.Test;
public class AssertionTests {
	@Test
    public void testAssertions() {

        //Checking Assert is equal or not
        assertEquals(5, 2 + 3);

        //Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert is null or not
        assertNull(null);

        // Assert Not Null
        assertNotNull(new Object());
}
}
