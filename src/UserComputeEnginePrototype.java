
import project.annotations.NetworkAPIPrototype;
//The Client Prototype
import project.*;
public class UserComputeEnginePrototype {
    
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(UserComputeEngineAPI api) {
        //The prototype takes the API as its only parameter
        InputSource source = new InputSource() {};
        OutputDestination destination = new OutputDestination() {};
        DelimiterOptions customDelimiters = new DelimiterOptions() {};

        //user specifies the input source, output destination, and delimiter
        JobConfigResult custom = api.configureJob(source, destination, customDelimiters);

        //allow the user to opt to use some default delimiter if they don't want to specify one
        JobConfigResult default = api.configureJobDefault(source, destination);
    }
}
