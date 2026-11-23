package portfolioThree;

public record LocalDistance(String placeName, int kilometers) {

    // Attributes

    // _________________________________________________________________________________________________________________

    @Override
    public String toString() {

        return "%s (%d km)".formatted(placeName, kilometers);

    }

}
