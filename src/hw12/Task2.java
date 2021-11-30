package hw12;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Task2 {

    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(4);
        executor.execute(new MyRunnable());
        executor.shutdown();
    }
}


