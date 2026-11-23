package portfolioThree;

public class SortMeasurement {

    // Attributes
    private int comparisonCount;
    private int swapCount;

    // _________________________________________________________________________________________________________________

    public int compare(LocalDistance firstDistance, LocalDistance secondDistance) {

        comparisonCount++;
        return Integer.compare(firstDistance.kilometers(), secondDistance.kilometers());

    }

    // _________________________________________________________________________________________________________________

    public void swap(LocalDistance[] distances, int firstIndex, int secondIndex) {

        if (firstIndex == secondIndex) {
            return;
        }

        LocalDistance savedDistance = distances[firstIndex];
        distances[firstIndex] = distances[secondIndex];
        distances[secondIndex] = savedDistance;
        swapCount++;

    }

    // _________________________________________________________________________________________________________________

    public int comparisonCount() {

        return comparisonCount;

    }

    // _________________________________________________________________________________________________________________

    public int swapCount() {

        return swapCount;

    }

}
