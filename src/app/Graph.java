package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Graph {
    private Map<Integer, Set<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int source, int destination) {
        if (!adjList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjList.containsKey(destination)) {
            addVertex(destination);
        }
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void removeVertex(int vertex) {
        if (adjList.containsKey(vertex)) {
            adjList.values().forEach(e -> e.remove(vertex));
            adjList.remove(vertex);
        }
    }

    public void removeEdge(int source, int destination) {
        Set<Integer> sourceNeighbors = adjList.get(source);
        Set<Integer> destinationNeighbors = adjList.get(destination);
        if (sourceNeighbors != null) {
            sourceNeighbors.remove(destination);
        }
        if (destinationNeighbors != null) {
            destinationNeighbors.remove(source);
        }
    }

    public boolean hasVertex(int vertex) {
        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(int source, int destination) {
        return adjList.containsKey(source) && adjList.get(source).contains(destination);
    }

    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print("Вершина " + vertex + " суміжна з: ");
            for (int neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
