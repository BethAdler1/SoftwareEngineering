package project.api;

public class DataStorageImpl implements DataStorageAPI {
    
    @Override
    public DataStream readInputData(InputSource source) {
        // IWill later read data from source and return a DataStream object
        return null;
    }
    @Override
    public WriteResult writeOutputData(OutputDestination destination, DataStream data) {
        // Will later write data to destination and return a WriteResult object
        return null;
    }
}
