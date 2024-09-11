package app;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        graph.printGraph();

        System.out.println("Чи існує вершина 3? " + graph.hasVertex(3));
        System.out.println("Чи існує вершина 5? " + graph.hasVertex(5));
        System.out.println("Чи існує ребро між 1 і 2? " + graph.hasEdge(1, 2));
        System.out.println("Чи існує ребро між 2 і 4? " + graph.hasEdge(2, 4));

        graph.removeVertex(4);
        graph.printGraph();

        graph.removeEdge(1, 2);
        graph.printGraph();
    }
}

