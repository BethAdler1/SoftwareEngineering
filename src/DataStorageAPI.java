import project.annotations.ProcessAPI;
import project.*;
//The API interface
@ProcessAPI
public interface DataStorageAPI {
    //read integer data from the input source as a stream
    DataStream readInputData(InputSource source);

    //Writes the computation results to the output destination
    WriteResult writeOutputData(OutputDestination destination, DataStream data);
  
}
