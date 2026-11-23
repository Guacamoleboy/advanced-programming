package portfolioThree;

public class QuickSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public SortMeasurement sort(LocalDistance[] distances, boolean showSteps) {

        return sort(distances, showSteps, false);

    }

    // _________________________________________________________________________________________________________________

    public SortMeasurement sortWithMiddlePivot(LocalDistance[] distances, boolean showSteps) {

        return sort(distances, showSteps, true);

    }

    // _________________________________________________________________________________________________________________

    private SortMeasurement sort(LocalDistance[] distances, boolean showSteps, boolean useMiddlePivot) {

        SortMeasurement measurement = new SortMeasurement();
        sort(distances, 0, distances.length - 1, measurement, showSteps, useMiddlePivot);
        return measurement;

    }

    // _________________________________________________________________________________________________________________

    private void sort(LocalDistance[] distances, int firstIndex, int lastIndex, SortMeasurement measurement,
                      boolean showSteps, boolean useMiddlePivot) {

        if (firstIndex >= lastIndex) {
            return;
        }

        if (useMiddlePivot) {
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
            measurement.swap(distances, middleIndex, lastIndex);
        }

        // Partition around the pivot at the end of this range.
        int pivotIndex = ArrayPartition.partition(distances, firstIndex, lastIndex, measurement);
        if (showSteps) {
            SortOutput.partition(distances, firstIndex, pivotIndex, lastIndex);
        }

        // The pivot is in place. Sort the two remaining ranges.
        sort(distances, firstIndex, pivotIndex - 1, measurement, showSteps, useMiddlePivot);
        sort(distances, pivotIndex + 1, lastIndex, measurement, showSteps, useMiddlePivot);

    }

}
