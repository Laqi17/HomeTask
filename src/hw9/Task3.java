package hw9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    private static final String PATH_TO_FILE = "src/resources/Task3/words.txt";

    public static void main(String[] args) {
        Map<String, Integer> wordsCount = new HashMap<>();
        List<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(PATH_TO_FILE))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }

        Map<String, Integer> sortedWordsCount = sortMap(wordsCount);

        sortedWordsCount.entrySet().forEach(System.out::println);

    }

    static Map<String, Integer> sortMap(Map<String, Integer> map) {
        TreeMap<String, Integer> result = new TreeMap<>(new MyComparator(map));
        result.putAll(map);
        return result;
    }

}

