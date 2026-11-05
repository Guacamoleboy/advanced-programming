package portfolioOne;

import java.util.Map;

// Task created by: CPH-JL325 - Jonas Meinert Larsen

public class PortfolioOne {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void main(String[] args) {

        // Example data setup -> pass it to each search algorithm. (SoC + OOP).
        RoadNetwork roadNetwork = LocalMaps.createRoadNetwork();
        GridMap grid = LocalMaps.createGridMap(roadNetwork);
        String start = "Hillerød";
        String goal = "Gilleleje";

        // Dijkstra task run setup + Run
        System.out.println("Roadnet:");
        for (City city : roadNetwork.getCities()) {
            for (Map.Entry<City, Integer> road : city.getNeighbors().entrySet()) {
                System.out.println(city.getName() + " -> " + road.getKey().getName() + ": " + road.getValue() + " km");
            }
        }
        new Dijkstra().findShortestPath(roadNetwork, roadNetwork.getCity(start), roadNetwork.getCity(goal));

        // A* task run setup + Run
        System.out.println("\nA*: " + start + " to " + goal + " on a 8x8-grid");
        System.out.println("Each step costs 1. Each cities coordinates are (row, column) from 0.");
        for (GridNode node : grid.getCityNodes()) {
            System.out.println(node.getCity().getName() + " " + node.position());
        }
        new AStar().findShortestPath(grid, grid.getCityNode(start), grid.getCityNode(goal));

    }

}