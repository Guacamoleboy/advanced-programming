package designpatterns.refactoring;

/**
 * Bruger en GraphSearchStrategy til at søge i grafen.
 * Strategien kan skiftes ved runtime — samme graf, forskellig søgealgoritme.
 */
public class GraphSearcher {

    private GraphSearchStrategy strategy;

    public GraphSearcher(GraphSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(GraphSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public Node search(String targetName, Node start) {
        return strategy.search(targetName, start);
    }
}
