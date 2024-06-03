Day-9-10;

import java.util.*;

class Djikstras {
    private Map<Integer, List<Edge>> adjList;

    public Djikstras() {
        this.adjList = new HashMap<>();
    }

    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));
    }

    public Map<Integer, String> dijkstra(int start) {
        Map<Integer, String> distances = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        
        for (int node : adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE+"");
        }
        distances.put(start, 0+"");
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentNode = edge.to;
            int currentDistance = edge.weight;

            for (Edge neighbor : adjList.get(currentNode)) {
                int newDist = currentDistance + neighbor.weight;
                if (newDist < Integer.parseInt(distances.get(neighbor.to))) {
                    distances.put(neighbor.to, newDist+"");
                    pq.add(new Edge(neighbor.to, newDist));
                }
            }
        }

        return distances;
    }

    class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Djikstras graph = new Djikstras();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 3);

        Map<Integer, String> distances = graph.dijkstra(4);
        for (Map.Entry<Integer,String> entry : distances.entrySet()) {
            System.out.println("Distance from 4 to " + entry.getKey() + " is " + (Integer.parseInt(entry.getValue())==Integer.MAX_VALUE? "Infinity":entry.getValue()));
        }
    }
}

