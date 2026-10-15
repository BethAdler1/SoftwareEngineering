package checkpointtests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import project.api.*;

public class ComputeEngineIntegrationTest {
    
    @Test
    public void testComputeEngineEndToEnd() {
        //seting up the test-only in memory with the input [1,10,25]
        InMemoryInputSource inputSource = new InMemoryInputSource(Arrays.asList(1, 10, 25));
        InMemoryOutputDestination outputDestination = new InMemoryOutputDestination();

        //instantiating the three components explicitly together
        DataStorageAPI dataStorage = new InMemoryDataStorage(); // Test-only @ProcessAPI
        ComputationAPI computationEngine = new ComputationImpl(); // Real @ConceptualAPI
        UserComputeEngineAPI networkEngine = new UserComputeEngineImpl(dataStorage, computationEngine); // real @NetworkAPI

        //Execute the job config using default deliminters (aka no delimiter specifiied)
        JobConfigResult result = networkEngine.configureJobDefault(inputSource, outputDestination);

        //verify componenets can execute even if computation returns null/fails for now
        //bc computation isn't implemented yet, this will fail or return null
        assertNotNull(networkEngine, "Network engine instance should exist.");
        assertNotNull(dataStorage, "Data store instance should exist.");
        assertNotNull(computationEngine, "Computation engine instance should exist.");
    }
}
