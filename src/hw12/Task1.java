package hw12;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Task1 {
    private static final Semaphore oxygen = new Semaphore(1);
    private static final Semaphore hydrogen = new Semaphore(2);


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
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

        for (int i = 0; i < 50; i++) {
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
