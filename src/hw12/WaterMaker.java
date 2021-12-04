package hw12;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class WaterMaker {
    static CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.print("\n"));
    static Semaphore oxygen = new Semaphore(1);
    static Semaphore hydrogen = new Semaphore(2);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toLowerCase(Locale.ROOT).toCharArray();

        for (int i = 0; i < line.length(); i++) {
            if(chars[i] == 'o') {
                new Oxygen(barrier, oxygen);
            } else if(chars[i] == 'h'){
                new Hydrogen(barrier, hydrogen);
            }
            else {
                System.out.println("incorrect");
            }
        }
        scanner.close();
    }
}
