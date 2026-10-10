package project.api;
import project.annotations.ProcessAPIPrototype;

//The Client Prototype
public class DataStoragePrototype {
    
    @ProcessAPIPrototype
    public void prototypeDataStorage(DataStorageAPI api) {
        //Mock input/output locations
        InputSource source = new InputSource() {};
        OutputDestination destination = new OutputDestination() {};

        //Read the data from storage
        DataStream inputData = api.readInputData(source);
        //In the full engine input data would be sent to ComputationAPI.
        //  for this prototype, proccessedData represents the datastream returned after computation
        DataStream processedData = new DataStream() {};
        //Write data back to destination
        WriteResult result = api.writeOutputData(destination, processedData);
       
    }
}
