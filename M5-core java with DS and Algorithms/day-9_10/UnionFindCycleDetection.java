Day-9_10;


public class UnionFindCycleDetection {
    private int[] parent, rank;

    public UnionFindCycleDetection(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                 parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean detectCycle(int[][] edges) {
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (find(from) == find(to)) {
                return true;
            }
            union(from, to);
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};

        UnionFindCycleDetection uf = new UnionFindCycleDetection(vertices);
        boolean hasCycle = uf.detectCycle(edges);

        System.out.println("Graph contains cycle: " + (hasCycle==true? "YES":"NO")); 
    }
}

