// Дан массив: ["1, 2, 0", "4, 5"] Получить из массива все числа, вернуть в отсортированном виде, разделенные запятой, то есть "0, 1, 2, 4, 5"


import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {
        String[] number = new String[]{"1, 2, 0", "4, 5"};
        String result = numberSorter(number);
        System.out.println(result);
    }

    private static String numberSorter(String[] number) {

        return Arrays.stream(number)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .sorted()
                .collect(Collectors.joining(", "));
    }

}
