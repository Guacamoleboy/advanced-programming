package designpatterns.refactoring;

import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper om en vægtet graf — giver adgang til noder via navn.
 */
public class Graph {
    private final Map<String, WeightedNode> nodes = new HashMap<>();

    public void addNode(String name) {
        nodes.put(name, new WeightedNode(name));
    }

    public void addEdge(String from, String to, int weight) {
        nodes.get(from).addNeighbor(nodes.get(to), weight);
    }

    public WeightedNode getNode(String name) {
        return nodes.get(name);
    }
}
