// Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, но не используя Math.random.
// Реализуйте свой "линейный конгруэнтный генератор". Для этого начните с x[0] = seed
// и затем каждый следующий элемент x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m.
// Необходимо имплементировать метод, который принимает на вход параметры, a, c, m и seed и возвращает Stream<Long>.
// Для теста используйте данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    public static void main(String[] args) {
        System.out.println(myRandomFull(6).limit(5).collect(Collectors.toList()));

    }

    static Stream<Long> myRandomFull (long seed)  {
        long a = 25214903917l;
        long c = 11;
        long m = (long) Math.pow(2, 48);

        return myRandom(a, c, m, seed);
    }

    static Stream<Long> myRandom(long a, long c, long m, long seed){
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

}
