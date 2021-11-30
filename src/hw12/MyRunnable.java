package hw12;

class MyRunnable implements Runnable {

    @Repeat(count = 4)
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
