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
        
        final List<Integer> singleOutput = (computationResult != null)
                ? Collections.singletonList((int) Math.round(computationResult.getResultValue() * 100.0))
                : Collections.emptyList();

        DataStream outputData = new DataStream() {
            @Override
            public List<Integer> getData() {
                return singleOutput;
            }
        };
        //Request data storage to write the output data stream to the destination
        WriteResult writeResult = dataStorageAPI.writeOutputData(destination, outputData);
        final boolean writeSucceeded = (writeResult != null) ? writeResult.isWriteSuccessful() : true;
        final boolean jobSucceeded = (computationResult != null) && writeSucceeded;
        //Return a job configuration result status back to the user
        return new JobConfigResult() {
            //add methods required by jobConfigResult interface
            @Override
            public boolean isSuccessful() {
                return jobSucceeded;
            }
        };
    }
    @Override
    public JobConfigResult configureJobDefault(InputSource source, OutputDestination destination) {
        //delegate default configuration to the main configJob method with null delimiters
        return configureJob(source, destination, null);
    }
}
