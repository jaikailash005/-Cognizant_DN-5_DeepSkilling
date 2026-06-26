import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 10, 20})
    void testEvenNumbers(int num) {
        assertTrue(checker.checkEven(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testOddNumbers(int num) {
        assertFalse(checker.checkEven(num));
    }
}