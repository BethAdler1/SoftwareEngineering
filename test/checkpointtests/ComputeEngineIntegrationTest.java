package checkpointtests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.UserComputeEngineAPI;
import project.api.impl.ComputationImpl;
import project.api.impl.UserComputeEngineImpl;
import project.api.JobConfigResult;

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

        assertNotNull(result, "JobConfigResult should not be null.");
        assertTrue(result.isSuccessful(), "Job configuration should be successful.");

        List<String> writtenOutputs = outputDestination.getOutputLines();
        assertNotNull(writtenOutputs, "Written outputs should not be null.");
        assertFalse(writtenOutputs.isEmpty(), "Written outputs should not be empty.");

        for (String entry : writtenOutputs) {
            int parsedValue = Integer.parseInt(entry.trim());
            assertTrue(
                parsedValue >= 0 && parsedValue <= 400, "Expected scaled pi estimate in [0, 400], but got: " + parsedValue);
            System.out.println("Output written to destination: " + parsedValue);
        }

        //verify componenets can execute even if computation returns null/fails for now
        //bc computation isn't implemented yet, this will fail or return null
        assertNotNull(networkEngine, "Network engine instance should exist.");
        assertNotNull(dataStorage, "Data store instance should exist.");
        assertNotNull(computationEngine, "Computation engine instance should exist.");
    }
}
