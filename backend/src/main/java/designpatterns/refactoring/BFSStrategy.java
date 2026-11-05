package designpatterns.refactoring;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Strategy: Breadth-First Search.
 * Besøger alle naboer før den går dybere — bruger en kø.
 */
public class BFSStrategy implements GraphSearchStrategy {

    @Override
    public Node search(String targetName, Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.getName().equals(targetName)) return current;
            queue.addAll(current.getNeighbors());
        }
        return null;
    }
}
