/*Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии (запуска программы)
  Другой ее поток выводит каждые 5 секунд сообщение  "Прошло 5 секунд". Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время.*/

public class Time {
    private volatile int i = 1;
    private final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        Time time = new Time();


        Thread thread1 = new Thread(() -> {
            time.showTime();
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            time.showMessage();

        });
        thread2.start();
    }

    public void showTime() {
        while (true) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitor) {
                System.out.println("Time frome start: " + i++ + " seconds");
                monitor.notifyAll();;
            }
        }
    }

    public void showMessage() {
            while (true) {
                if (i % 5 == 0) {
                    System.out.println("Прошло 5 секунд");
                    synchronized (monitor) {
                        try {
                           monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }
}

