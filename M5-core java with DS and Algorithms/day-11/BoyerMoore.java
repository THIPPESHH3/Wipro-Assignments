package Day_11;

public class BoyerMoore {

    private final int NO_OF_CHARS = 256;

    private void badCharHeuristic(char[] str, int size, int[] badChar) {
        for (int i = 0; i < NO_OF_CHARS; i++)
            badChar[i] = -1;

        for (int i = 0; i < size; i++)
            badChar[(int) str[i]] = i;
    }

    public int search(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;

        int[] badChar = new int[NO_OF_CHARS];
        badCharHeuristic(pattern, m, badChar);

        int s = 0;
        int lastOccurrence = -1;

        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pattern[j] == text[s + j])
                j--;

            if (j < 0) {
                lastOccurrence = s;
                s += (s + m < n) ? m - badChar[text[s + m]] : 1;
            } else
                s += Math.max(1, j - badChar[text[s + j]]);
        }

        return lastOccurrence;
    }

    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore();
        String text = "ABAAABCDF";
        String pattern = "ABC";
        int result = bm.search(text.toCharArray(), pattern.toCharArray());

        if (result == -1)
            System.out.println("Pattern not found in the text.");
        else
            System.out.println("Last occurrence of the pattern found at index " + result);
    }
}
