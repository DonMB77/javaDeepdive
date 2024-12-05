package IO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigMap {

    public static void getValueFromConfigMap(Path configMapFilePath, String keyName) throws FileNotFoundException, IOException {
        try (var fileInputStream = new FileInputStream(configMapFilePath.toString())) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }
        }
    }

    public static void main (String[] args) throws IOException {
        Path path = Paths.get("config.txt");
        getValueFromConfigMap(path, "discount");
    }
}