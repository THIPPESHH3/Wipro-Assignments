package Day-18;
public class StatesAndTransition {

    public static void main(String[] args) throws InterruptedException {
        LifecycleTask lifecycleTask = new LifecycleTask();

        Thread thread1 = new Thread(lifecycleTask::doWork);
        Thread thread2 = new Thread(lifecycleTask::doWorkWithWait);

        System.out.println("State after creating thread1: " + thread1.getState()); 

        thread1.start();
        thread2.start();
        System.out.println("State after starting thread1: " + thread1.getState()); 
        Thread.sleep(100);
        System.out.println("State of thread1 while running: " + thread1.getState());
        System.out.println("State of thread2 while running: " + thread2.getState()); 
        synchronized (lifecycleTask) {
            lifecycleTask.notify();
        }

        thread1.join(); 
        thread2.join();

        System.out.println("State of thread1 after finishing task: " + thread1.getState());
        System.out.println("State of thread2 after finishing task: " + thread2.getState()); 
    }

    static class LifecycleTask {
        public void doWork() {
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public void doWorkWithWait() {
            synchronized (this) {
                try {
                    wait(500); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
