package checkpointtests;

import project.api.ComputationAPI;

import project.api.DataStorageAPI;
import project.api.DelimiterOptions;
import project.api.FileInputSource;
import project.api.InputSource;
import project.api.FileOutputDestination;
import project.api.JobConfigResult;
import project.api.OutputDestination;
import project.api.UserComputeEngineAPI;
import project.api.impl.ComputationImpl;
import project.api.impl.DataStorageImpl;
import project.api.impl.UserComputeEngineImpl;

import java.nio.file.Path;


public class ManualTestingFramework {
    
    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {
        // 
        // Instantiate a real (ie, class definition lives in the src/ folder) implementation 
        // of all 3 APIs
        DataStorageAPI dataStorage = new DataStorageImpl();
        ComputationAPI computationEngine = new ComputationImpl();
        UserComputeEngineAPI networkEngine = new UserComputeEngineImpl(dataStorage, computationEngine);
        //
        // 
        // Run a computation with an input file of <root project dir>/manualTestInput.txt
        // and an output of <root project dir>/manualTestOutput.txt, with a delimiter of ',' 
        InputSource inputSource = new FileInputSource(Path.of(INPUT));
        OutputDestination outputDestination = new FileOutputDestination(Path.of(OUTPUT));

        // If DelimiterOptions is an interface/class, instantiate or mock/implement it as needed:
        DelimiterOptions commaDelimiter = new DelimiterOptions() {
        @Override
        public char getDelimiter() {
            return ',';
        }

        @Override
        public boolean isDefault() {
            return false;
            }
        };

        JobConfigResult result = networkEngine.configureJob(inputSource, outputDestination, commaDelimiter);
        System.out.println("Job completed. Success: " + (result != null && result.isSuccessful()));
        //
        //
        // Helpful hint: the working directory of this program is <root project dir>,
        // so you can refer to the files just using the INPUT/OUTPUT constants. You do not 
        // need to (and should not) actually create those files in your repo
    }
}
