package project.api;

import java.nio.file.Path;
import java.util.Objects;

public class FileOutputDestination implements OutputDestination {
    private final Path filePath;

    public FileOutputDestination(Path filePath) {
        this.filePath = Objects.requireNonNull(filePath);
    }

    public Path getFilePath() {
        return filePath;
    }
    
}
