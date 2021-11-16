// Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
// который "перемешивает" элементы из стримов first и second, останавливается тогда, когда у одного из стримов закончатся элементы.


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("Ssad", "asdsa", "asd ");
        Stream<String> stream2 = Stream.of("223", null, "1234sasxc", "1212edfsacxc");

        System.out.println(zip(stream1, stream2).collect(Collectors.toList()));

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Stream<T> result = Stream.empty();

        while(iterator1.hasNext() && iterator2.hasNext()) {
            result = Stream.concat(result, Stream.of(iterator1.next(), iterator2.next()));
        }


        return result;
    }
}
