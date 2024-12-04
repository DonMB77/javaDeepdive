package IO;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dmarc\\OneDrive\\Desktop");
        file.mkdir();

        //or as hierarchy:
        file = new File("testDir2\\innerTestDir2");
        file.mkdirs();

        // In Java we generally aim for platform independent code. Therefor we can utilize the following logic:
        file = new File("testDir3" + File.separator + "innerTestDir3");
        if (file.mkdirs()) {
            System.out.println("Successfully created files.");
        } else {
            System.out.println("Files do already exist.");
        }

        System.out.println("File separator: " + File.separator);
        System.out.println("Path separator: " + File.pathSeparator);

        String writing = "This is a test" + System.lineSeparator() + "new line";
        file = new File("result.csv");
        file.createNewFile();

        file.exists();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
        }

        file.getAbsolutePath();
        file.canExecute();

        file.isFile();

        file.isHidden();

        File[] listOfFiles = file.listFiles(pathname -> pathname.getName().endsWith(".java"));
    }
}
