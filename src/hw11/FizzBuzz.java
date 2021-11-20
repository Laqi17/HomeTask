package hw11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class FizzBuzz {
    public int n;
    public int count;
    public StringBuilder result = new StringBuilder(" ");
    List<String> list = new ArrayList<>();

    public StringBuilder getResult() {
        return result;
    }

    public FizzBuzz(int n) {
        this.n = n;
        this.count = 1;
    }

    synchronized public void fizz() throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                count++;
                list.add("fizz");
                notifyAll();
            } else {
                wait();
            }
        }
    }

    synchronized public void buzz() throws InterruptedException {
        while (count <= n) {
            if (count % 5 == 0 && count % 3 != 0) {
                list.add("buzz");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    synchronized public void fizzbuzz() throws InterruptedException {
        while (count <= n) {
            if (count % 15 == 0) {
                list.add("fizzBuzz");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    synchronized public void number() throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 || count % 5 == 0) {
                wait();
            } else {
                list.add(count + "");
                count++;
                notifyAll();
            }
        }
    }

    public String showResult(List<String> list) {
       return list.stream().collect(Collectors.joining(", "));
    }

    public static void main(String[] args) throws InterruptedException {

        FizzBuzz fizzBuz = new FizzBuzz(20);

        Thread thread1 = new Thread(() -> {
            try {
                fizzBuz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                fizzBuz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
                fizzBuz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();

        Thread thread4 = new Thread(() -> {
            try {
                fizzBuz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(fizzBuz.showResult(fizzBuz.list));

    }
}
