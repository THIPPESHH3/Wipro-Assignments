Day-18;

public class ThreadSafe_ImmutableObject {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) {
        ThreadSafe_ImmutableObject counter = new ThreadSafe_ImmutableObject();
        Runnable incrementTask = counter::increment;
        Runnable decrementTask = counter::decrement;

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(decrementTask);
        Thread t3 = new Thread(incrementTask);
       // Thread t4 = new Thread(decrementTask);

        t1.start();
        t2.start();
        t3.start();
      //  t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            //t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}

final class ImmutableData {
    private final int value;

    public ImmutableData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

