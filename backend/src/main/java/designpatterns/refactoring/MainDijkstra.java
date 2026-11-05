package designpatterns.refactoring;

public class MainDijkstra {

    public static void main(String[] args) {
        Graph graph = GraphFactory.createDijkstraTestGraph();
        Dijkstra.findShortestPath(graph.getNode("S"), graph.getNode("M"));
    }
}