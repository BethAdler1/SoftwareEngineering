
import project.annotations.NetworkAPI;
import project.*;

//The API Interface
@NetworkAPI
public interface UserComputeEngineAPI {
    //using custom delimiters
    JobConfigResult configureJob(InputSource source, OutputDestination destination, DelimiterOptions delimiters);
    //using default delimiters
    JobConfigResult configureJobDefault(InputSource source, OutputDestination destination);
}
