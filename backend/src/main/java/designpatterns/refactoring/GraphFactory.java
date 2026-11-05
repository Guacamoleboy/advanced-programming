package designpatterns.refactoring;

/**
 * Factory-pattern: centraliserer oprettelse af grafer.
 *
 * Samspillet med Graph (Builder-ånden):
 * Factory bestemmer HVAD der bygges.
 * Graph håndterer HVORDAN — tilføjer noder og kanter trin for trin.
 */
public class GraphFactory {

    public static Graph createDijkstraTestGraph() {
        Graph graph = new Graph();
        graph.addNode("S"); graph.addNode("A"); graph.addNode("B"); graph.addNode("C");
        graph.addNode("D"); graph.addNode("E"); graph.addNode("F"); graph.addNode("G");
        graph.addNode("H"); graph.addNode("I"); graph.addNode("J"); graph.addNode("K");
        graph.addNode("L"); graph.addNode("M");

        graph.addEdge("S", "A", 1); graph.addEdge("S", "B", 3); graph.addEdge("S", "C", 2);
        graph.addEdge("A", "D", 2); graph.addEdge("B", "D", 5); graph.addEdge("B", "E", 4);
        graph.addEdge("C", "E", 1); graph.addEdge("C", "F", 3); graph.addEdge("D", "G", 3);
        graph.addEdge("E", "G", 6); graph.addEdge("E", "H", 3); graph.addEdge("F", "I", 2);
        graph.addEdge("G", "H", 1); graph.addEdge("G", "J", 7); graph.addEdge("H", "J", 2);
        graph.addEdge("H", "K", 5); graph.addEdge("I", "K", 3); graph.addEdge("I", "L", 4);
        graph.addEdge("J", "M", 3); graph.addEdge("K", "M", 4); graph.addEdge("L", "M", 8);

        return graph;
    }
}