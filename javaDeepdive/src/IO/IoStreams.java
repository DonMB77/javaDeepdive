package IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IoStreams {

    public static void main(String[] args) throws IOException {
        String filePath = "testDir" + File.separator + "demo.txt";
        String textToWrite = "Some text example " + System.lineSeparator() + "with a line separator and some japanese characters: "
                + "これはテストの文章です。" + System.lineSeparator();

        // writing examples:
        writeToPathFileOutputStream(filePath, textToWrite);
        writeToPathFileOutputStreamWithBuffer(filePath, textToWrite);
    }

    // writing methods:
    private static void writeToPathFileOutputStream(String path, String textToWrite) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            byte[] bytes = textToWrite.getBytes();
            fileOutputStream.write(bytes);
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    private static void writeToPathFileOutputStreamWithBuffer(String path, String textToWrite) throws FileNotFoundException, IOException {
        try (var fileOutputStreamWithBuffer = new BufferedOutputStream(new FileOutputStream(path))) {
            fileOutputStreamWithBuffer.write(textToWrite.getBytes());
            fileOutputStreamWithBuffer.flush();
        }
    }

    private static void writeToPathFileWriter(String path, String textToWrite) throws FileNotFoundException, IOException {
        try (var fileWriter = new FileWriter(path)) {
            fileWriter.write(textToWrite);
        }
    }

    private static void writeToPathFileWriterBuffered(String path, String textToWrite) throws FileNotFoundException, IOException {
        try (var bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(textToWrite);
        }
    }

    // Read Methods:

    // this method will only be able to read the first 256 chars of unicode table. Japanese characters won't work.
    private static void printFileUsingFileInputStream(String path) throws FileNotFoundException, IOException {
        try (var fileInputStream = new FileInputStream(path)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }
        }
    }

    private static void printFileUsingFileInputStreamWithBuffer(String path) throws IOException {
        try (var fileInputStream = new FileInputStream(path);
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

    private static void printFileUsingFileReader(String path) throws FileNotFoundException, IOException {
        try (var fileReader = new FileReader(path)) {
            int contentBeingRead;
            while ((contentBeingRead = fileReader.read()) != -1) {
                System.out.println((char) contentBeingRead);
            }
        }
    }

    private static void PrintFileUsingBufferedReader(String path) throws FileNotFoundException, IOException {
        try (var bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // NIO write methods:
    private static void writeNio(String path, String textToBeWritten) throws IOException {
        Files.write(Paths.get(path), textToBeWritten.getBytes());
        List<String> lines = Arrays.asList("a", "s", "d");
        Files.write(Paths.get(path), lines, StandardCharsets.UTF_8);
    }

    // NIO read methods:
    private static void printFileToConsoleNio(String path) throws IOException {
        try (Stream<String> fileStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            fileStream.forEach(System.out::println);
        }

        List<String> readAllLines = Files.readAllLines(Paths.get(path));
    }

    private static void printFileToConsoleUsingCustomEncoding(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path), Charset.forName("windows-1251"))) {
            SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
            stream.forEach(System.out::println);
        }
    }

    private static void findMethod(String path, int depth) throws IOException {
        Path startPath = Paths.get(path);
        try (Stream<Path> stream = Files.find(startPath, depth, (specificPath, attribute) -> String.valueOf(specificPath).endsWith(".java"))) {
            String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining(";"));
            if (joined != null && !joined.isEmpty()) {
                System.out.println("Found: " + joined);
            }
        }
    }

    private static void walkMethod(String path) throws IOException {
        Files.walk(Paths.get(path)).filter(p -> p.toString().endsWith(".ext"))
                .map(p -> p.getParent().getParent())
                .distinct()
                .forEach(System.out::println);
    }
}
