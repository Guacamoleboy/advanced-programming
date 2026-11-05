package portfolioOne;

import java.util.List;

public class RoadNetwork {

    // Attributes
    private final List<City> cities;

    // _________________________________________________________________________________________________________________

    public RoadNetwork(List<City> cities) {
        this.cities = List.copyOf(cities);
    }

    // _________________________________________________________________________________________________________________

    public List<City> getCities() {
        return cities;
    }

    // _________________________________________________________________________________________________________________

    public City getCity(String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        throw new IllegalArgumentException("The city is not found in the roadnet: " + name);
    }

}