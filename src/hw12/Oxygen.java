package hw12;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {
    CyclicBarrier barrier;
    Semaphore oxygen;

    public Oxygen(CyclicBarrier barrier, Semaphore oxygen) {
        this.barrier = barrier;
        this.oxygen = oxygen;
        this.start();
    }

    private void releaseOxeygen() {
        System.out.print("O");
    }

    @Override
    public void run() {
        try {
            oxygen.acquire();
            barrier.await();
            releaseOxeygen();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        oxygen.release();
    }
}