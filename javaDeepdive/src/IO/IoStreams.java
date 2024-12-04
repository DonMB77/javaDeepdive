package IO;

import java.io.File;
import java.io.IOException;

public class IoStreams {

    public static void main (String[] args) throws IOException {
        String filePath = "testDirectory" + File.separator + "demo.txt";
        String textToWrite = "Some text example " + System.lineSeparator() + "with a line separator and some japanese characters: "
                + "これはテストの文章です。" + System.lineSeparator();

        // writing examples:
        
    }
}
