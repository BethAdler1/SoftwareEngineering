package project.api;

import java.util.Collections;
import java.util.List;

public class UserComputeEngineImpl implements UserComputeEngineAPI {

    private final DataStorageAPI dataStorageAPI;
    private final ComputationAPI computationAPI;
    
    //explicit constructor wiring the dependencies
    public UserComputeEngineImpl(DataStorageAPI dataStorageAPI, ComputationAPI computationAPI) {
        this.dataStorageAPI = dataStorageAPI;
        this.computationAPI = computationAPI;
    }
    @Override
    public JobConfigResult configureJob(InputSource source, OutputDestination destination, DelimiterOptions delimiters) {
        //Request data storage to read input data from the source
        DataStream inputData = dataStorageAPI.readInputData(source);

        //Pass the input data stream to the computation component
        //passing default config for now
        ComputationConfig config = null;
        ComputationResult computationResult = computationAPI.performComputation(inputData, config);

        //wrap the computation result into an output Datastream, since dataStream provides List<Integer> getData() the computed result can be into a list format dataStore can write
        DataStream outputData = new DataStream() {    
            @Override
            public List<Integer> getData() {
                if (computationResult == null) {
                    return Collections.emptyList();
                }
                //wrap the computed result into a list format
                return Collections.singletonList((int) computationResult.getResultValue() * 100);
            }
        };
        //Request data storage to write the output data stream to the destination
        WriteResult writeResult = dataStorageAPI.writeOutputData(destination, outputData);

        final boolean writeSucceeded = (writeResult != null) ? writeResult.isWriteSuccessful() : true;
        
        //Return a job configuration result status back to the user
        return new JobConfigResult() {
            //add methods required by jobConfigResult interface
            @Override
            public boolean isSuccessful() {
                return computationResult != null && writeSucceeded;
            }
        };
    }
    @Override
    public JobConfigResult configureJobDefault(InputSource source, OutputDestination destination) {
        //delegate default configuration to the main configJob method with null delimiters
        return configureJob(source, destination, null);
    }
}
