import project.annotations.ConceptualAPIPrototype;

public class ComputationPrototype {
    
    @ConceptualAPIPrototype
    public void prototypeComputation(ComputationAPI api) {
        //Mock dependencys managed by the Cordinator component
        DataStream mockDataStream = new DataStream() {};
        ComputationConfig mockConfig = new ComputationConfig() {};

        //The Coordinator aka user calls the computation component API
        ComputationResult result = api.performComputation(mockDataStream, mockConfig);
    }
}
