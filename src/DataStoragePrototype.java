import project.annotations.ProcessAPIPrototype;
import project.*;
//The Client Prototype
public class DataStoragePrototype {
    
    @ProcessAPIPrototype
    public void prototypeDataStorage(DataStorageAPI api) {
        //Mock input/output
        InputSource source = new InputSource() {};
        OutputDestination destination = new OutputDestination() {};

        //Read the data 
        DataStream inputData = api.readInputData(source);

        //Write data back to destination
        WriteResult result = api.writeOutputData(destination, inputData);
       
    }
}
