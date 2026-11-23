package portfolioThree;

import java.util.Arrays;

// Learning
// ________
//
// Base case = Fewer than 2 values. Nothing left to split.
// Merge writes back into the input array.

public class MergeSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public SortMeasurement sort(LocalDistance[] distances, boolean showSteps) {

        SortMeasurement measurement = new SortMeasurement();
        sort(distances, measurement, showSteps, 0);
        return measurement;

    }

    // _________________________________________________________________________________________________________________

    private void sort(LocalDistance[] distances, SortMeasurement measurement, boolean showSteps, int depth) {

        if (distances.length < 2) {
            return;
        }

        // Divide.
        int middleIndex = distances.length / 2;
        LocalDistance[] leftHalf = Arrays.copyOfRange(distances, 0, middleIndex);
        LocalDistance[] rightHalf = Arrays.copyOfRange(distances, middleIndex, distances.length);
        if (showSteps) {
            SortOutput.divide(leftHalf, rightHalf, depth);
        }

        // Solve each half recursively.
        sort(leftHalf, measurement, showSteps, depth + 1);
        sort(rightHalf, measurement, showSteps, depth + 1);

        // Combine.
        ArrayMerge.merge(distances, leftHalf, rightHalf, measurement);
        if (showSteps) {
            SortOutput.merged(distances, depth);
        }

    }

}
