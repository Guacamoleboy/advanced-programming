package designpatterns.refactoring;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Strategy: Depth-First Search.
 * Følger én sti så langt som muligt før den backtracker — bruger en stak.
 */
public class DFSStrategy implements GraphSearchStrategy {

    @Override
    public Node search(String targetName, Node start) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.getName().equals(targetName)) return current;
            for (Node neighbor : current.getNeighbors()) {
                stack.push(neighbor);
            }
        }
        return null;
    }
}
