package designpatterns.refactoring;

/**
 * Sammenlign med den originale SearchStrategies.main():
 * BFS og DFS var statiske metoder i samme klasse — ingen fælles interface,
 * algoritmen kunne ikke skiftes dynamisk.
 *
 * Nu er BFS og DFS udskiftelige strategier — samme søger, forskellig algoritme.
 */
public class MainGraphSearch {

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.addNeighbor(B);
        A.addNeighbor(C);
        A.addNeighbor(D);
        C.addNeighbor(E);

        GraphSearcher searcher = new GraphSearcher(new BFSStrategy());
        Node result = searcher.search("E", A);
        System.out.println("BFS fandt: " + (result != null ? result.getName() : "intet"));

        searcher.setStrategy(new DFSStrategy());
        result = searcher.search("E", A);
        System.out.println("DFS fandt: " + (result != null ? result.getName() : "intet"));
    }
}
