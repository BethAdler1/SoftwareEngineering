package smoketests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

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
        assertNotNull(readData, "Expected a non-null DataStream from readInputData.");
        assertTrue(readData.getData().isEmpty(), "Expected the DataStream to be empty for the smoke test.");


        WriteResult writeResult = storageApi.writeOutputData(mockDestination, mockDataStream);
        assertNotNull(writeResult, "Expected a non-null WriteResult from writeOutputData.");
        assertFalse(writeResult.isWriteSuccessful(), "Expected the write operation to be unsuccessful for the smoke test.");
       // assertNull(readData);
       // assertNull(writeResult);
    }
    
}
