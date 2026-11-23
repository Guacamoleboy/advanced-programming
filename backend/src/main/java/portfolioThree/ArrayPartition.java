package portfolioThree;

// Learning
// ________
//
// The last element is the Lomuto pivot.
// On sorted input, a last-element pivot leaves one side empty, giving O(n²) comparisons.

public class ArrayPartition {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static int partition(LocalDistance[] distances, int firstIndex, int lastIndex,
                                SortMeasurement measurement) {

        LocalDistance pivot = distances[lastIndex];
        int nextLeftIndex = firstIndex;

        // Extend the left partition whenever an element is at most the pivot.
        for (int index = firstIndex; index < lastIndex; index++) {
            if (measurement.compare(distances[index], pivot) <= 0) {
                measurement.swap(distances, index, nextLeftIndex);
                nextLeftIndex++;
            }
        }

        measurement.swap(distances, nextLeftIndex, lastIndex);
        return nextLeftIndex;

    }

}
