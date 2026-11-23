package portfolioThree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class DistanceData {

    // Attributes
    static final int SHARED_DISTANCE = 9;

    // _________________________________________________________________________________________________________________

    public static LocalDistance[] createDistances() {

        return new LocalDistance[]{
                new LocalDistance("Græsted", 14),
                new LocalDistance("Gadevang", 2),
                new LocalDistance("Nødebo", SHARED_DISTANCE),
                new LocalDistance("Fredensborg", 7),
                new LocalDistance("Gilleleje", 20),
                new LocalDistance("Hammersholt", 3),
                new LocalDistance("Esrum", SHARED_DISTANCE),
                new LocalDistance("Harløse", 5),
                new LocalDistance("Helsinge", 12),
                new LocalDistance("Humlebæk", 11),
                new LocalDistance("Hornbæk", 16),
                new LocalDistance("Skævinge", 6)
        };

    }

    // _________________________________________________________________________________________________________________

    public static LocalDistance[] shuffledCopy(LocalDistance[] distances) {

        LocalDistance[] shuffled = distances.clone();
        // Use the same shuffle each run so the two 9 km entries can be followed in the output.
        Collections.shuffle(Arrays.asList(shuffled), new Random(8));
        return shuffled;

    }

    // _________________________________________________________________________________________________________________

    public static LocalDistance[] sortedCopy(LocalDistance[] distances) {

        LocalDistance[] sorted = distances.clone();
        Arrays.sort(sorted, Comparator.comparingInt(LocalDistance::kilometers));
        return sorted;

    }

    // _________________________________________________________________________________________________________________

    public static LocalDistance[] reversedCopy(LocalDistance[] sortedDistances) {

        LocalDistance[] reversed = sortedDistances.clone();
        Collections.reverse(Arrays.asList(reversed));
        return reversed;

    }

    // _________________________________________________________________________________________________________________

    public static LocalDistance[] repeatSorted(LocalDistance[] sortedDistances, int copies) {

        LocalDistance[] larger = new LocalDistance[sortedDistances.length * copies];
        int offsetStep = sortedDistances[sortedDistances.length - 1].kilometers() + 1;

        // Offset each copy so the expanded example stays sorted.
        for (int copyIndex = 0; copyIndex < copies; copyIndex++) {
            for (int index = 0; index < sortedDistances.length; index++) {
                LocalDistance distance = sortedDistances[index];
                larger[copyIndex * sortedDistances.length + index] =
                        new LocalDistance(distance.placeName(), distance.kilometers() + copyIndex * offsetStep);
            }
        }
        return larger;

    }

}
