package smoketests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import project.api.ComputationAPI;
import project.api.ComputationImpl;
import project.api.ComputationResult;
import project.api.ComputationConfig;
import project.api.DataStream;

public class TestComputationAPI {

    @Test
    public void testComputationSmokeTest() {
        //Arranging the inputs/ mock objects for the computation API
        DataStream mockDataStream = mock(DataStream.class); //uses mockito instead of manual anonymous classes
        ComputationConfig mockConfig = mock(ComputationConfig.class);
        
        //Initializing the implementation class of the ComputationAPI
        ComputationAPI computationEngine = new ComputationImpl(); //has explicit constructor
        //calling the method performComputation for testing
       ComputationResult result = computationEngine.performComputation(mockDataStream, mockConfig);
    
        //Asserting the result to check if it is null as expected for the smoke test
       assertNull(result, "The computation result should be null for the smoke test.");
    }
    
}
