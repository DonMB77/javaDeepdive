package IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioDemo {

    public static void main(String[] args) throws IOException {
        // uses Path instead of File. Therefor files and operation are utilized through the path.
        Path path = Paths.get("TestDirNio1", "innerTestDirNio1");

        Files.isDirectory(path);
        Files.isRegularFile(path);
        Files.createDirectories(path);

        Path filePath = Paths.get("TestDirNio1", "result.csv");
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        Files.delete(path);
    }
}
