package Day-18;

public class CreatingAndManagingThreads implements Runnable {
    private String threadName;

    public CreatingAndManagingThreads(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(threadName + " interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CreatingAndManagingThreads("Thread 1"));
        Thread thread2 = new Thread(new CreatingAndManagingThreads("Thread 2"));

        thread1.start();
        thread2.start();
    }
}

