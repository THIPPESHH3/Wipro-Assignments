Day-9_10;

import java.util.*;

class Kruskal {
    private int vertices;
    private List<Edge> edges;

    public Kruskal(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    public List<Edge> kruskal() {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));
        UnionFind uf = new UnionFind(vertices);

        for (Edge edge : edges) {
            if (uf.find(edge.from) != uf.find(edge.to)) {
                mst.add(edge);
                uf.union(edge.from, edge.to);
            }
        }

        return mst;
    }

    class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    class UnionFind {
        private int[] parent, rank;

        public UnionFind(int size) {
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
    }

    public static void main(String[] args) {
        Kruskal graph = new Kruskal(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        List<Edge> mst = graph.kruskal();
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.from + " - " + edge.to + " with weight: " + edge.weight);
        }
    }
}


