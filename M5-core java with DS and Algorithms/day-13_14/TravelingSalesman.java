package Day-13_14;

import java.util.Arrays;

public class TravelingSalesman {

    public static int FindMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[n][1 << n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return tsp(0, 1, graph, dp, VISITED_ALL);
    }

    private static int tsp(int pos, int mask, int[][] graph, int[][] dp, int VISITED_ALL) {
        if (mask == VISITED_ALL) {
            return graph[pos][0];
        }

        if (dp[pos][mask] != -1) {
            return dp[pos][mask];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < graph.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = graph[pos][city] + tsp(city, mask | (1 << city), graph, dp, VISITED_ALL);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[pos][mask] = ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("The minimum cost to visit all cities is: " + FindMinCost(graph));
    }
}

