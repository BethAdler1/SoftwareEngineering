package smoketests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import project.api.ComputationAPI;
import project.api.ComputationResult;
import project.api.ComputationConfig;
import project.api.DataStream;
import project.api.impl.ComputationImpl;

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
        assertNotNull(result, "The computation result should not be null.");
        assertEquals(1_000_000L, result.getExecutionMetric(), "Expected default 1,000,000 trials.");
        assertTrue(
                result.getResultValue() >= 0.0 && result.getResultValue() <= 4.0,
                "Estimated pi should be within [0.0, 4.0]."
        );
       //assertNull(result, "The computation result should be null for the smoke test.");
    }
    
}
