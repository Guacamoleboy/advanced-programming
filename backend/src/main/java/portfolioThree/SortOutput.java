package portfolioThree;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortOutput {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void input(String title, LocalDistance[] distances) {

        System.out.printf("%n%s%n%s%n", title, Arrays.toString(distances));
        matchingDistances(distances);

    }

    // _________________________________________________________________________________________________________________

    public static void stepHeading(String sortName, boolean showSteps) {

        if (showSteps) {
            System.out.printf("%n%s steps%n", sortName);
        }

    }

    // _________________________________________________________________________________________________________________

    public static void result(String sortName, LocalDistance[] distances, SortMeasurement measurement,
                              boolean countSwaps) {

        System.out.printf("%s result: %s%n", sortName, Arrays.toString(distances));
        matchingDistances(distances);
        measurement(measurement, countSwaps);

    }

    // _________________________________________________________________________________________________________________

    public static void measurement(SortMeasurement measurement, boolean countSwaps) {

        System.out.printf("Comparisons: %d", measurement.comparisonCount());
        if (countSwaps) {
            System.out.printf(" | Swaps: %d", measurement.swapCount());
        }
        System.out.println();

    }

    // _________________________________________________________________________________________________________________

    private static void matchingDistances(LocalDistance[] distances) {

        String places = Arrays.stream(distances)
                .filter(distance -> distance.kilometers() == DistanceData.SHARED_DISTANCE)
                .map(LocalDistance::placeName)
                .collect(Collectors.joining(" -> "));

        System.out.printf("Order at %d km: %s%n", DistanceData.SHARED_DISTANCE, places);

    }

    // _________________________________________________________________________________________________________________

    public static void bubblePass(LocalDistance[] distances, int unsortedEnd, boolean swapped) {

        int passNumber = distances.length - unsortedEnd;
        if (!swapped) {
            System.out.printf("Pass %d: no swaps, the whole array is sorted.%n", passNumber);
            return;
        }

        System.out.printf("Pass %d: %s | In place: %s%n", passNumber,
                range(distances, 0, unsortedEnd), range(distances, unsortedEnd, distances.length));

    }

    // _________________________________________________________________________________________________________________

    public static void divide(LocalDistance[] leftHalf, LocalDistance[] rightHalf, int depth) {

        System.out.printf("%sDivide into %s and %s%n", "  ".repeat(depth),
                Arrays.toString(leftHalf), Arrays.toString(rightHalf));

    }

    // _________________________________________________________________________________________________________________

    public static void merged(LocalDistance[] distances, int depth) {

        System.out.printf("%sMerged: %s%n", "  ".repeat(depth), Arrays.toString(distances));

    }

    // _________________________________________________________________________________________________________________

    public static void partition(LocalDistance[] distances, int firstIndex, int pivotIndex, int lastIndex) {

        System.out.printf("Pivot %s in place at index %d | Left (%d): %s | Right (%d): %s%n",
                distances[pivotIndex], pivotIndex,
                pivotIndex - firstIndex, range(distances, firstIndex, pivotIndex),
                lastIndex - pivotIndex, range(distances, pivotIndex + 1, lastIndex + 1));

    }

    // _________________________________________________________________________________________________________________

    public static void heapAfterSwap(LocalDistance[] distances, int heapSize) {

        System.out.printf("Placed %s at index %d.%n", distances[heapSize], heapSize);
        heap(distances, heapSize);

    }

    // _________________________________________________________________________________________________________________

    public static void heap(LocalDistance[] distances, int heapSize) {

        System.out.printf("Heap in array: %s | In place: %s%n",
                range(distances, 0, heapSize), range(distances, heapSize, distances.length));

        int level = 0;
        for (int levelStart = 0; levelStart < heapSize; levelStart = 2 * levelStart + 1) {
            int levelEnd = Math.min(2 * levelStart + 1, heapSize);
            System.out.printf("  Level %d: %s%n", level, range(distances, levelStart, levelEnd));
            level++;
        }

    }

    // _________________________________________________________________________________________________________________

    private static String range(LocalDistance[] distances, int startIndex, int endIndex) {

        return Arrays.toString(Arrays.copyOfRange(distances, startIndex, endIndex));

    }

}
