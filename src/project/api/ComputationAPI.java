package project.api;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface ComputationAPI {
    
    //performs computation on the provided input data stream usign the given param
    ComputationResult performComputation(DataStream inputData, ComputationConfig config);
}
