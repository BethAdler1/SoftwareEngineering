package smoketests;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.InputSource;
import project.api.OutputDestination;
import project.api.DelimiterOptions;
import project.api.UserComputeEngineAPI;
import project.api.UserComputeEngineImpl;
import project.api.JobConfigResult;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
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
