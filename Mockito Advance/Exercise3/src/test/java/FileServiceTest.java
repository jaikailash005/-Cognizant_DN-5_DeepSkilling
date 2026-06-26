import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {

        // Create mock objects
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // Stub file reader
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Create service
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // Execute
        String result = fileService.processFile();

        // Verify result
        assertEquals("Processed Mock File Content", result);

        // Verify write operation
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}