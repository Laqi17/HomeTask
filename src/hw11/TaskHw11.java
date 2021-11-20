/*Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии (запуска программы)
  Другой ее поток выводит каждые 5 секунд сообщение  "Прошло 5 секунд". Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время.*/

import java.util.Date;

public class TaskHw11 {
    private static int i = 1;
    private static boolean ready  = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thred1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Time frome start: " + i++ + " seconds");

                if (i % 5 == 0) {
                    ready = true;
                } else ready = false;
            }
        });
        thred1.start();

        Thread thred2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Прошло 5 секунд");
            }
        });

        thred2.start();
    }
}

