import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {

        // Create mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Stub network interaction
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Create service
        NetworkService networkService = new NetworkService(mockNetworkClient);

        // Execute method
        String result = networkService.connectToServer();

        // Verify result
        assertEquals("Connected to Mock Connection", result);
    }
}