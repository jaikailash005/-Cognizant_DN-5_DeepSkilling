import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {

        // Create mock repository
        Repository mockRepository = mock(Repository.class);

        // Stub multiple return values
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // Create service
        Service service = new Service(mockRepository);

        // Call twice
        String firstResult = service.processData();
        String secondResult = service.processData();

        // Verify results
        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
    }
}