package hu.webler.advance.graph;

import java.util.Arrays;

public class GraphAlgorithms {

    public static void main(String[] args) {

        depthFirstSearchExample();
        dijkstraExample();
    }

    public static void depthFirstSearchExample() {
        // Example graph for DFS
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        DFS(graph, 2);
    }

    // Legrövidebb út (Dijkstra algoritmus)
    public static void dijkstraExample() {
        // Example graph for Dijkstra
        WeightedGraph weightedGraph = new WeightedGraph(5);
        weightedGraph.addEdge(0, 1, 2);
        weightedGraph.addEdge(0, 2, 4);
        weightedGraph.addEdge(1, 2, 1);
        weightedGraph.addEdge(1, 3, 7);
        weightedGraph.addEdge(2, 4, 3);
        weightedGraph.addEdge(3, 4, 1);

        dijkstra(weightedGraph, 0);
    }

    // Mélységi keresés (Depth First Search)
    public static void DFS(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.getV()];
        System.out.print("Depth First Search: ");
        DFSUtil(graph, startVertex, visited);
        System.out.println();
    }

    private static void DFSUtil(Graph graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Integer neighbor : graph.adj[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(graph, neighbor, visited);
            }
        }
    }

    public static void dijkstra(WeightedGraph graph, int sourceVertex) {
        int V = graph.V;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[sourceVertex] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (Node neighbor : graph.adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!sptSet[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        System.out.println("Dijkstra's Shortest Path:");
        printDijkstra(dist);
    }

    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printDijkstra(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}