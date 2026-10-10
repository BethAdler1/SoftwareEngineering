
import java.util.ArrayList;
import java.util.List;
import project.api.OutputDestination;

public class InMemoryOutputDestination implements OutputDestination {
    private final List<String> outputLines = new ArrayList<>();

    public List<String> getOutputLines() {
        return outputLines;
    }
}
