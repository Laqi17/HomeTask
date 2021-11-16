package hw9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

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
                wordsCount.put(word, (Integer) wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }

        Map<String, Integer> sortedWordsCount = sortMap(wordsCount);
        sortedWordsCount.entrySet().forEach(System.out::println);

    }

    static Map<String, Integer> sortMap(Map<String, Integer> map) {
        Set<Entry<String, Integer>> entries = map.entrySet();
        Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return (e2.getValue()).compareTo(e1.getValue());
            }
        };

        List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);

        Collections.sort(listOfEntries, valueComparator);

        Map<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());

        for(Entry<String, Integer> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        return sortedByValue;
    }

}

