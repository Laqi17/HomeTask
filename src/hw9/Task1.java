package hw9;

import java.io.*;
import java.util.regex.Pattern;

public class Task1 {
    private static final String PATH_TO_FILE = "src/resources/Task1/file.txt";
    private static final String CONDITION1 = "([0-9]+(-[0-9]+)+)";
    private static final String CONDITION2 = "\\([0-9]+\\)\\s[0-9]+-[0-9]+";

    public static void main(String[] args) {
        File file = new File(PATH_TO_FILE);
        checkFileForValidPhone(file);
    }

    private static void checkFileForValidPhone(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String phone = bufferedReader.readLine();
                if (validPhone(phone)) {
                    System.out.println(phone);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean validPhone(String phone) {
        return Pattern.matches(CONDITION1, phone) || Pattern.matches(CONDITION2, phone);
    }
}
