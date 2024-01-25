package hu.webler.advance.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    int V;
    List<List<Node>> adjList;

    WeightedGraph(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>());
    }

    void addEdge(int source, int destination, int weight) {
        Node node = new Node(destination, weight);
        adjList.get(source).add(node);
    }
}