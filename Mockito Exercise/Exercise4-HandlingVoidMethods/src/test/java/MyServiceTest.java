import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVoidMethod() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the void method
        doNothing().when(mockApi).sendData();

        // Create service
        MyService service = new MyService(mockApi);

        // Call the method
        service.execute();

        // Verify interaction
        verify(mockApi).sendData();
    }
}