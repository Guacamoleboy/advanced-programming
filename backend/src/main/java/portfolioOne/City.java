package portfolioOne;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class City {

    // Attributes
    private final String name;
    private final Map<City, Integer> neighbors = new LinkedHashMap<>();

    // _________________________________________________________________________________________________________________

    public City(String name) {
        this.name = name;
    }

    // _________________________________________________________________________________________________________________

    public String getName() {
        return name;
    }

    // _________________________________________________________________________________________________________________

    public Map<City, Integer> getNeighbors() {
        // Roads must be added through addRoad so the distance is checked.
        return Collections.unmodifiableMap(neighbors);
    }

    // _________________________________________________________________________________________________________________

    public void addRoad(City neighbor, int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("A road can not be negative!");
        }
        neighbors.put(neighbor, distance);
    }

}