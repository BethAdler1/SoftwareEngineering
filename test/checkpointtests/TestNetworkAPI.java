package checkpointtests;
import org.junit.jupiter.api.Test;
import project.api.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
public class TestNetworkAPI {
    
    @Test
    public void testUSerComputeEngineSmokeTest() {
        //Arrange dependencies and params
        DataStorageAPI mockStorage = mock(DataStorageAPI.class);
        ComputationAPI mockComputation = mock(ComputationAPI.class);

        InputSource mockSource = mock(InputSource.class);
        OutputDestination mockDestination = mock(OutputDestination.class);
        DelimiterOptions mockDelimiters = mock(DelimiterOptions.class);

        //Constructor call
        UserComputeEngineAPI engineAPI = new UserComputeEngineImpl(mockStorage, mockComputation);

        JobConfigResult customResult = engineAPI.configureJob(mockSource, mockDestination, mockDelimiters);
        JobConfigResult defaultResult = engineAPI.configureJobDefault(mockSource, mockDestination);

        //Assert that results return null currently
        assertNull(customResult);
        assertNull(defaultResult);
    }
}
