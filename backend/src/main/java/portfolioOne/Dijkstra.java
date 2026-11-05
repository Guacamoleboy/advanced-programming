package portfolioOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// Learning
// ________
// dist = Cheapest KNOWN distance.
// prev = City we came from.
// visited = Cities already selected and visited.

public class Dijkstra {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void findShortestPath(RoadNetwork roadNetwork, City start, City goal) {

        List<City> cities = roadNetwork.getCities();
        Map<City, Integer> dist = new HashMap<>();
        Map<City, City> prev = new HashMap<>();
        Set<City> visited = new HashSet<>();
        PriorityQueue<NodeWithDist> queue = new PriorityQueue<>();

        // No route is known yet. Only start has a known distance of 0.
        for (City city : cities) {
            dist.put(city, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        queue.add(new NodeWithDist(start, 0));

        // Output 1
        System.out.println("\nDijkstra: " + start.getName() + " til " + goal.getName());
        printTable(cities, dist, prev, visited);

        while (!queue.isEmpty()) {

            // Greedy choice
            NodeWithDist current = queue.poll();
            if (visited.contains(current.getCity())) {
                continue;
            }

            // Output 2
            System.out.println("\nChooses " + current.getCity().getName() + " with dist = " + current.getDistance());

            // Stop when goal is SELECTED, not when it is first found as a neighbor.
            if (current.getCity() == goal) {
                visited.add(current.getCity());
                System.out.println("Goal has been visited. Ending program.");
                printTable(cities, dist, prev, visited);
                break;
            }

            // Loop
            for (Map.Entry<City, Integer> road : current.getCity().getNeighbors().entrySet()) {
                City next = road.getKey();
                if (visited.contains(next)) {
                    continue;
                }

                // Total distance from start via current, including the next road.
                int newDist = current.getDistance() + road.getValue();
                if (newDist < dist.get(next)) {
                    System.out.println("  " + next.getName() + ": dist " + formatDistance(dist.get(next)) + " -> " + newDist + " km, prev = " + current.getCity().getName());

                    // Update distance and previous city together for a cheaper route.
                    dist.put(next, newDist);
                    prev.put(next, current.getCity());
                    queue.add(new NodeWithDist(next, newDist));
                }
            }

            visited.add(current.getCity());
            System.out.println(current.getCity().getName() + " is now visited.");
            printTable(cities, dist, prev, visited);

        }

        // Validation
        if (!visited.contains(goal)) {
            System.out.println("There is no route to " + goal.getName());
            return;
        }

        // Follow prev from goal to start, but build the output in forward order.
        List<String> path = new ArrayList<>();
        City step = goal;
        while (step != null) {
            path.add(0, step.getName());
            step = prev.get(step);
        }

        // Final output (Output 3)
        System.out.println("\nShortest route: " + String.join(" -> ", path));
        System.out.println("Total distance: " + dist.get(goal) + " km");

    }

    // _________________________________________________________________________________________________________________

    private void printTable(List<City> cities, Map<City, Integer> dist, Map<City, City> prev, Set<City> visited) {
        // Print each city's current distance, previous city and visited status.
        System.out.println("By | dist (km) | prev | visited");

        for (City city : cities) {
            String previous = prev.containsKey(city) ? prev.get(city).getName() : "-";
            System.out.println(city.getName() + " | " + formatDistance(dist.get(city)) + " | " + previous + " | " + visited.contains(city));
        }

    }

    // _________________________________________________________________________________________________________________

    private String formatDistance(int distance) {
        return distance == Integer.MAX_VALUE ? "unknown" : String.valueOf(distance);
    }

}