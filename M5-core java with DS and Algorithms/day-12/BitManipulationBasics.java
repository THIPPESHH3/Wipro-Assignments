package Day-12;

public class BitManipulationBasics {

    
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

   
    public static int countTotalSetBits(int n) {
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            totalCount += countSetBits(i);
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of set bits in " + n + ": " + countSetBits(n));
        System.out.println("Total number of set bits from 1 to " + n + ": " + countTotalSetBits(n));
    }
}

