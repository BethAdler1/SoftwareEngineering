package project.api;
//wrapper for computation output/results
public interface ComputationResult {
    //the computed value
    double getResultValue();

    //metadata about the execution
    long getExecutionMetric();
}
