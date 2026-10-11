package project.api;

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
        //read data from source
        return null;
    }
    @Override
    public JobConfigResult configureJobDefault(InputSource source, OutputDestination destination) {
        //read data from source
        return null;
    }
}
