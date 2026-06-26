import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {

        // Create mock REST client
        RestClient mockRestClient = mock(RestClient.class);

        // Stub predefined response
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Create service
        ApiService apiService = new ApiService(mockRestClient);

        // Test service
        String result = apiService.fetchData();

        // Verify result
        assertEquals("Fetched Mock Response", result);
    }
}