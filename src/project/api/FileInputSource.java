package project.api;

import java.nio.file.Path;
import java.util.Objects;

public class FileInputSource implements InputSource {
    private final Path filePath;

    public FileInputSource(Path filePath) {
        this.filePath = Objects.requireNonNull(filePath);
    }

    public Path getFilePath() {
        return filePath;
    }
    
}
