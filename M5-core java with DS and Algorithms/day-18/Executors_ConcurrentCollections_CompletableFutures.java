package Day-18;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executors_ConcurrentCollections_CompletableFutures {

    public static void main(String[] args) {
        int upperLimit = 100;
        ExecutorService executor = Executors.newFixedThreadPool(4);

        CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() -> findPrimes(upperLimit), executor);

        future.thenAcceptAsync(primes -> {
            try (FileWriter writer = new FileWriter("primes.txt")) {
                for (int prime : primes) {
                    writer.write(prime + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executor);

        future.join();
        executor.shutdown();
    }

    public static List<Integer> findPrimes(int upperLimit) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= upperLimit; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

