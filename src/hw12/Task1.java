package hw12;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private static final Semaphore oxygen = new Semaphore(1);
    private static final Semaphore hydrogen = new Semaphore(2);
    static int h = 10;
    static int o = 14;


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < Math.min(o * 2, h); i++) {
            new Thread(() -> {
                try {
                    hydrogen.acquire();
                    releaseHydrogen();
                    Thread.sleep(100);
                    hydrogen.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        for (int i = 0; i < Math.min(o, h / 2); i++) {
            new Thread(() -> {
                try {
                    oxygen.acquire();
                    releaseOxeygen();
                    Thread.sleep(100);
                    oxygen.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }

    private static void releaseOxeygen() {
        System.out.print("O");
    }

    private static void releaseHydrogen() {
        System.out.print("H");
    }

}
