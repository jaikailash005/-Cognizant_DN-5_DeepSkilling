import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3));
    }
}