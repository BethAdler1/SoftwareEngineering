package project.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorageImpl implements DataStorageAPI {
    
    @Override
    public DataStream readInputData(InputSource source) {
        // IWill later read data from source and return a DataStream object
// Check if the source is our file-based input source
        if (source instanceof FileInputSource) {
            Path path = ((FileInputSource) source).getFilePath();
            try {
                // Read all lines from the file
                List<String> lines = Files.readAllLines(path);
                List<Integer> numbers = new ArrayList<>();

                for (String line : lines) {
                    // Split by whitespace or commas to handle multiple numbers per line
                    String[] tokens = line.split("[,\\s]+");
                    for (String token : tokens) {
                        if (!token.isBlank()) {
                            numbers.add(Integer.parseInt(token.trim()));
                        }
                    }
                }

                // Return an anonymous DataStream wrapping the read integers
                final List<Integer> resultNumbers = Collections.unmodifiableList(numbers);
                return new DataStream() {
                    @Override
                    public List<Integer> getData() {
                        return resultNumbers;
                    }
                };
            } catch (IOException | NumberFormatException e) {
                // Log or handle reading error gracefully
                e.printStackTrace();
            }
        }

        // Fallback for empty or unrecognized input sources
        return new DataStream() {
            @Override
            public List<Integer> getData() {
                return Collections.emptyList();
            }
        };
    }
    @Override
    public WriteResult writeOutputData(OutputDestination destination, DataStream data) {
    boolean success = false;

        if (destination instanceof FileOutputDestination && data != null) {
            Path path = ((FileOutputDestination) destination).getFilePath();
            List<Integer> values = data.getData();

            // Convert integers to strings for file writing
            List<String> lines = values.stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            try {
                // Ensure parent directories exist and write lines to file
                if (path.getParent() != null) {
                    Files.createDirectories(path.getParent());
                }
                Files.write(path, lines);
                success = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        final boolean finalSuccess = success;
        // Return a WriteResult implementation indicating the status
        return new WriteResult() {
            @Override
            public boolean isWriteSuccessful() {
                return finalSuccess;
            }
        };
    }
}
