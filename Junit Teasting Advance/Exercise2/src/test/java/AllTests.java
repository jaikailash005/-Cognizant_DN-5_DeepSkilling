import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    AdditionTest.class,
    MultiplicationTest.class
})
public class AllTests {
}