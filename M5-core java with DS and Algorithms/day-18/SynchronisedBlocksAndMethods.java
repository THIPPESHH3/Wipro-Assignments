package Day-18;

public class SynchronisedBlocksAndMethods {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Attempted to withdraw: " + amount);
        }
    }

    public static void main(String[] args) {
        SynchronisedBlocksAndMethods account = new SynchronisedBlocksAndMethods();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                account.deposit(10);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(10);
            }
        });

        t1.start();
        t2.start();
    }
}

