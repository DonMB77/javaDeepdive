package IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigMap {

    public static void getValueFromConfigMapPathType(Path configMapFilePath, String keyName) throws FileNotFoundException, IOException {
        try (var fileInputStream = new FileInputStream(configMapFilePath.toFile());
             var bufferedInputStream = new BufferedInputStream(fileInputStream);
             var dataInputStream = new DataInputStream(bufferedInputStream);
        ) {
            int i;

            while (dataInputStream.available() != 0) {
                System.out.println(dataInputStream.readLine());
                System.out.println();
            }
        }
    }

    public static String getValueFromConfigMapStringInput(String configMapFilePath, String keyName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(configMapFilePath));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.lineSeparator();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // delete the last new lineSeparator
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        reader.close();

        String content = stringBuilder.toString();
        return content;
    }

    public static String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
        if (configMapFilePath == null || keyName == null) {
            return null;
        }
        Map<String, String> collect = Files.lines(configMapFilePath)
                .collect(Collectors.toMap(line -> ((String)line).split("=")[0],
                        line -> ((String)line).split("=")[1]));

        return collect.get(keyName);
    }

    public static void main (String[] args) throws IOException {
        String pathString = "testDir" + File.separator + "config.txt";
        Path path = Paths.get(pathString);
        String content = getValueFromConfigMapStringInput(pathString, "discount");
        System.out.println(content);
/*        Path path = Paths.get("config.txt");
        String arg1 = getValueFromConfigMap(path, "database.user");
        System.out.println(arg1);*/
    }
}