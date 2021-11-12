package hw9;

import java.io.File;
import java.io.IOException;

public class FileCrietor {

    public FileCrietor() {
    }

    public static void crieatFile(File file, File jsonFile) {
        if (!jsonFile.exists()) {
            jsonFile.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
