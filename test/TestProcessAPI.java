import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import project.api.DataStorageAPI;
import project.api.DataStorageImpl;
import project.api.DataStream;
import project.api.InputSource;
import project.api.OutputDestination;
import project.api.WriteResult;

public class TestProcessAPI {

    @Test
    public void testDataStorageAPI() {
        //Arrange inputs/mock data
        InputSource mockSource = mock(InputSource.class);
        OutputDestination mockDestination = mock(OutputDestination.class);
        DataStream mockDataStream = mock(DataStream.class);

        //Instattiatingn the API implementation
        DataStorageAPI storageApi = new DataStorageImpl();
        //invocation of the API methods
        DataStream readData = storageApi.readInputData(mockSource);
        WriteResult writeResult = storageApi.writeOutputData(mockDestination, mockDataStream);
        
        assertNull(readData);
        assertNull(writeResult);
    }
    
}
