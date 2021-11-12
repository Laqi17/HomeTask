package hw9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public Writer() {
    }

    public void writeToJsonFile(String jsonUser, File jsonFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile))) {
            bufferedWriter.write(jsonUser);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
