package portfolioThree;

public class BubbleSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public SortMeasurement sort(LocalDistance[] distances, boolean showSteps) {

        SortMeasurement measurement = new SortMeasurement();

        // Each pass puts the largest remaining distance at the unsorted end.
        for (int unsortedEnd = distances.length - 1; unsortedEnd > 0; unsortedEnd--) {

            boolean swapped = false;
            for (int index = 0; index < unsortedEnd; index++) {
                if (measurement.compare(distances[index], distances[index + 1]) > 0) {
                    measurement.swap(distances, index, index + 1);
                    swapped = true;
                }
            }

            if (showSteps) {
                SortOutput.bubblePass(distances, unsortedEnd, swapped);
            }

            if (!swapped) {
                break;
            }

        }

        return measurement;

    }

}
