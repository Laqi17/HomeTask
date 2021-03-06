package hw12;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public void execute(@NotNull Runnable command) {
        for (Method method : command.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat repeat = method.getAnnotation(Repeat.class);

                for (int i = 0; i < repeat.count(); i++) {
                    super.execute(command);
                }

            }
        }

    }
}
