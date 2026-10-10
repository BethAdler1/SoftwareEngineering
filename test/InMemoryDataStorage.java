import project.api.*;
import java.util.List;

public class InMemoryDataStorage implements DataStorageAPI {
    
    @Override
    public DataStream readInputData(InputSource source) {
        if (source instanceof InMemoryInputSource) {
            InMemoryInputSource inMemorySource = (InMemoryInputSource) source;

            return new DataStream() {
                @Override
                public List<Integer> getData() {
                    return inMemorySource.getInputNums();
                }
            };
        }
        return null;
    }

    @Override
    public WriteResult writeOutputData(OutputDestination destination, DataStream data) {
        if (destination instanceof InMemoryOutputDestination) {
            InMemoryOutputDestination inMemoryDestination = (InMemoryOutputDestination) destination;
            
            for (Integer num : data.getData()) {
                inMemoryDestination.getOutputLines().add(num.toString());
            }
            return new WriteResult(){};
        }
        return null;
    }
}
