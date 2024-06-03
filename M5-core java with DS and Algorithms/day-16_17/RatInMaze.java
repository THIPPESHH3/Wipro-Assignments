package Day-16_17;

public class RatInMaze {

    private static int N = 6;

    public static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[N][N];
        if (!solveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(solution);
        return true;
    }

    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            solution[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }

            if (solveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }

            solution[x][y] = 0; // Backtracking
            return false;
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    private static void printSolution(int[][] solution) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(solution[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            { 1, 0, 0, 0, 0, 0 },
            { 1, 1, 0, 1, 1, 1 },
            { 0, 1, 0, 1, 0, 0 },
            { 1, 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1 }
        };

        solveMaze(maze);
    }
}

