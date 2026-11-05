package portfolioOne;

public class NodeWithCost implements Comparable<NodeWithCost> {

    // Attributes
    private final GridNode node;
    private final int g;
    private final int f;

    // _________________________________________________________________________________________________________________

    public NodeWithCost(GridNode node, int g, int h) {
        this.node = node;
        this.g = g;
        this.f = g + h;
    }

    // _________________________________________________________________________________________________________________

    public GridNode getNode() {
        return node;
    }

    // _________________________________________________________________________________________________________________

    public int getG() {
        return g;
    }

    // _________________________________________________________________________________________________________________

    public int getF() {
        return f;
    }

    // _________________________________________________________________________________________________________________
    // The lowest f = g + h comes first in the priority queue.

    @Override
    public int compareTo(NodeWithCost other) {
        return Integer.compare(f, other.f);
    }

}