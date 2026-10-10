import project.api.InputSource;
import java.util.List;

public class InMemoryInputSource implements InputSource {
    private final List<Integer> inputNums;

    public InMemoryInputSource(List<Integer> inputNums) {
        this.inputNums = inputNums;
    }
    public List<Integer> getInputNums() {
        return inputNums;
    }

}
