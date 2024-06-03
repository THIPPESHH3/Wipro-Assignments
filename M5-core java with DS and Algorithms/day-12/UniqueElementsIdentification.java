package Day-12;

public class UniqueElementsIdentification {

    public static int[] findTwoUniqueElements(int[] nums) {
        int xor = 0;

       
        for (int num : nums) {
            xor ^= num;
        }

       
        int setBit = xor & ~(xor - 1);

        int x = 0, y = 0;

       
        for (int num : nums) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4};
        int[] uniqueElements = findTwoUniqueElements(nums);
        System.out.println("The two unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
    }
}

