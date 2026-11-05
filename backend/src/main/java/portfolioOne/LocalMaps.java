package portfolioOne;

import java.util.List;

public class LocalMaps {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static RoadNetwork createRoadNetwork() {

        // Create each city once - shared across both systems.
        City hilleroed = new City("Hillerød");
        City noedebo = new City("Nødebo");
        City gadevang = new City("Gadevang");
        City esrum = new City("Esrum");
        City graested = new City("Græsted");
        City fredensborg = new City("Fredensborg");
        City soeborg = new City("Søborg");
        City gilleleje = new City("Gilleleje");

        // Adds to a list.
        List<City> cities = List.of(hilleroed, noedebo, gadevang, esrum, graested, fredensborg, soeborg, gilleleje);

        // Each road is one-way. Simplified.
        hilleroed.addRoad(noedebo, 9);
        hilleroed.addRoad(gadevang, 2);
        gadevang.addRoad(noedebo, 3);
        gadevang.addRoad(esrum, 7);
        gadevang.addRoad(graested, 10);
        noedebo.addRoad(esrum, 2);
        noedebo.addRoad(fredensborg, 9);
        esrum.addRoad(graested, 2);
        esrum.addRoad(fredensborg, 4);
        graested.addRoad(soeborg, 3);
        fredensborg.addRoad(soeborg, 2);
        fredensborg.addRoad(gilleleje, 8);
        soeborg.addRoad(gilleleje, 2);
        gilleleje.addRoad(hilleroed, 20);

        return new RoadNetwork(cities);
    }

    // _________________________________________________________________________________________________________________

    public static GridMap createGridMap(RoadNetwork roadNetwork) {

        // Grid setup.
        int[][] layout = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 0}
        };

        // Place existing cities on open cells.
        GridMap grid = new GridMap(layout);
        grid.placeCity(roadNetwork.getCity("Hillerød"), 0, 0);
        grid.placeCity(roadNetwork.getCity("Græsted"), 0, 7);
        grid.placeCity(roadNetwork.getCity("Nødebo"), 2, 0);
        grid.placeCity(roadNetwork.getCity("Esrum"), 2, 4);
        grid.placeCity(roadNetwork.getCity("Gadevang"), 4, 3);
        grid.placeCity(roadNetwork.getCity("Fredensborg"), 6, 0);
        grid.placeCity(roadNetwork.getCity("Søborg"), 7, 5);
        grid.placeCity(roadNetwork.getCity("Gilleleje"), 7, 7);
        return grid;
    }

}