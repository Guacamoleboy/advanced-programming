package portfolioOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// Learning:
// ________
//
// dist -> g -> Cheapest KNOWN distance from start
// Calculation should be f = g + h

public class AStar {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void findShortestPath(GridMap grid, GridNode start, GridNode goal) {

        Map<GridNode, Integer> dist = new HashMap<>(); // dist stores g
        Map<GridNode, GridNode> prev = new HashMap<>(); // prev stores the node we came from
        Set<GridNode> visited = new HashSet<>();
        PriorityQueue<NodeWithCost> queue = new PriorityQueue<>();

        // Start costs 0 to reach
        dist.put(start, 0);
        queue.add(new NodeWithCost(start, 0, heuristic(start, goal)));

        // Stop when goal is selected, or no reachable nodes remain in the queue.
        while (!queue.isEmpty()) {

            // Pick lowest f
            NodeWithCost current = queue.poll();
            if (visited.contains(current.getNode())) {
                continue;
            }

            int h = heuristic(current.getNode(), goal);

            // Output while looping
            System.out.println("Chooses " + current.getNode().position() + ": g = " + current.getG() + ", h = " + h + ", f = " + current.getF() + " -> visited");

            visited.add(current.getNode());
            if (current.getNode() == goal) {
                break;
            }

            for (GridNode next : grid.getNeighbors(current.getNode())) {
                if (visited.contains(next)) {
                    continue;
                }

                // Each move to an OPEN neighbor costs 1.
                int newDist = current.getG() + 1;

                // For the same neighbor, h stays the same, so we compare g (dist).
                if (newDist < dist.getOrDefault(next, Integer.MAX_VALUE)) {
                    dist.put(next, newDist);
                    prev.put(next, current.getNode());

                    // Add a new entry; changing an existing entry would not reorder the queue.
                    queue.add(new NodeWithCost(next, newDist, heuristic(next, goal)));

                    // Logging
                    System.out.println("  " + next.position() + ": dist = " + newDist + ", prev = " + current.getNode().position());
                }

            }
        }

        // No route was found if goal was never selected from the queue.
        if (!visited.contains(goal)) {
            System.out.println("There is no road to the goal.. !");
            return;
        }

        // Adding each node at the front of the path while following prev backwards.
        List<GridNode> path = new ArrayList<>();
        GridNode step = goal;
        while (step != null) {
            path.add(0, step);
            step = prev.get(step);
        }

        List<String> positions = new ArrayList<>();
        for (GridNode node : path) {
            positions.add(node.position());
        }

        System.out.println("\nShortest route: " + String.join(" -> ", positions));
        System.out.println("Number of steps: " + dist.get(goal));

    }

    // _________________________________________________________________________________________________________________

    private int heuristic(GridNode node, GridNode goal) {
        // Ignores walls and counts row and column differences. (Manhattan)
        return Math.abs(node.getRow() - goal.getRow()) + Math.abs(node.getCol() - goal.getCol());
    }

}