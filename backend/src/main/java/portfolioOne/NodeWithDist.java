package portfolioOne;

// Learning
// ________
//
// Dijkstra only needs the distance from start

public class NodeWithDist implements Comparable<NodeWithDist> {

    // Attributes
    private final City city;
    private final int distance;

    // _________________________________________________________________________________________________________________

    public NodeWithDist(City city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    // _________________________________________________________________________________________________________________

    public City getCity() {
        return city;
    }

    // _________________________________________________________________________________________________________________

    public int getDistance() {
        return distance;
    }

    // _________________________________________________________________________________________________________________

    @Override
    public int compareTo(NodeWithDist other) {
        return Integer.compare(distance, other.distance);
    }

}