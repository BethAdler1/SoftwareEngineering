package smoketests;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.InputSource;
import project.api.OutputDestination;
import project.api.DelimiterOptions;
import project.api.UserComputeEngineAPI;
import project.api.impl.UserComputeEngineImpl;
import project.api.JobConfigResult;


import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        assertNotNull(customResult, "expected a non null jobConfigResult for custom job configuration");
        assertNotNull(defaultResult, "expected a non null jobConfigResult for default job configuration");
        //unstubbed mock computationAPI, performComputation resturns null, so jobsucceeded also evaluates to false in usercomputeEngineImpl 
        assertFalse(customResult.isSuccessful(), "expected jobConfigResult to be unsuccessful for custom job configuration");
        assertFalse(defaultResult.isSuccessful(), "expected jobConfigResult to be unsuccessful for default job configuration");
    }
}
