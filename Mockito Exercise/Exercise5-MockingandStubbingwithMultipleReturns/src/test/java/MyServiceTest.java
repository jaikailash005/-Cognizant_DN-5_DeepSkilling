import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {

        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub multiple return values
        when(mockApi.getData())
                .thenReturn("First Value")
                .thenReturn("Second Value")
                .thenReturn("Third Value");

        // Create service
        MyService service = new MyService(mockApi);

        // Verify returned values
        assertEquals("First Value", service.fetchData());
        assertEquals("Second Value", service.fetchData());
        assertEquals("Third Value", service.fetchData());
    }
}