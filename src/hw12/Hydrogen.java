package hw12;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {
    CyclicBarrier barrier;
    Semaphore hydrogen;

    public Hydrogen(CyclicBarrier barrier, Semaphore hydrogen) {
        this.barrier = barrier;
        this.hydrogen = hydrogen;
        this.start();
    }

    private void releaseHydrogen() {
        System.out.print("H");
    }

    @Override
    public void run() {
        try {
            hydrogen.acquire();
            barrier.await();
            releaseHydrogen();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        hydrogen.release();

    }
}