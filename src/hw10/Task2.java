// Метод принимает на вход список из строк (можно список из Задания 1). Возвращает список этих строк в верхнем регистре и отсортированные по убыванию (от Z до А).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Ivan", "Roman", "Frank", "Boris", "Obama", "Elon", "Peter", "Aaron"));

        List<String> result = sort(list);
        System.out.println(result);

    }

    private static List<String> sort(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
