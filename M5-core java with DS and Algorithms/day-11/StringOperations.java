package Day-11;
public class StringOperations {

    public static String performStringOperations(String str1, String str2, int length) {
        
        String concatenated = str1 + str2;
        String reversed = new StringBuilder(concatenated).reverse().toString();
        
        int n = reversed.length();
        if (length > n) {
            length = n; 
        }
        int start = (n - length) / 2;
        
        return reversed.substring(start, start + length);
    }

    public static void main(String[] args) {
      
        System.out.println(performStringOperations("hello", "world", 5));  // Output: "dlrow"
        System.out.println(performStringOperations("abc", "def", 4));     // Output: "fedc"
        System.out.println(performStringOperations("", "xyz", 2));        // Output: "yz"
        System.out.println(performStringOperations("abc", "def", 10));    // Output: "fedcba"
    }
}


