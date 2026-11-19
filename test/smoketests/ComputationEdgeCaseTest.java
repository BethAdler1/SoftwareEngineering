package smoketests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.ComputationConfig;
import project.api.ComputationImpl;
import project.api.ComputationResult;
import project.api.DataStream;

public class ComputationEdgeCaseTest {
    @Test
    public void testEmptyDataStreamUsesDefaultTrialsAndEstimatesPi() {
        DataStream emptyStream = mock(DataStream.class);
        when(emptyStream.getData()).thenReturn(Collections.emptyList());
        ComputationConfig mockConfig = mock(ComputationConfig.class);

        ComputationAPI computationEngine = new ComputationImpl();
        ComputationResult result = computationEngine.performComputation(emptyStream, mockConfig);

        assertNotNull(result, "ComputationResult should not be null for an empty stream.");
        assertEquals(1_000_000L, result.getExecutionMetric(), "Should fall back to 1,000,000 trials.");
        assertTrue(
                result.getResultValue() >= 3.0 && result.getResultValue() <= 3.3,
                "Estimated pi with 1,000,000 trials should be reasonably close to pi, got: " + result.getResultValue()
        );
    }
}
