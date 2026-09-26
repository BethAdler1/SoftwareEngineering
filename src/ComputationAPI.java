import project.annotations.ConceptualAPI;

public interface ComputationAPI {
    
    //performs computation on the provided input data stream usign the given param
    ComputationResult performComputation(DataStream inputData, ComputationConfig config);
}
