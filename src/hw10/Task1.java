// Метод принимает на вход список имен. Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка, стоящими под нечетным индексом (1, 3 и т.д.).


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Ivan", "Roman", "Frank Sinatra", "Obama", "Elon Mask", "Peter"));
        String result = getFilteredResult(list);
        System.out.println(result);
    }


    private static String getFilteredResult(List<String> list) {
        return list.stream().
                filter(i -> list.indexOf(i) % 2 != 0).
                map(x -> list.indexOf(x) + ". " + x).
                collect(Collectors.joining(", "));
    }

}