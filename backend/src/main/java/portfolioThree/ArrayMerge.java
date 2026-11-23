package portfolioThree;

public class ArrayMerge {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void merge(LocalDistance[] distances, LocalDistance[] leftHalf, LocalDistance[] rightHalf,
                             SortMeasurement measurement) {

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        // Taking the left element first on a tie preserves the original order.
        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (measurement.compare(leftHalf[leftIndex], rightHalf[rightIndex]) <= 0) {
                distances[mergedIndex] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                distances[mergedIndex] = rightHalf[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // Copy the remaining elements from the half that still has elements.
        while (leftIndex < leftHalf.length) {
            distances[mergedIndex] = leftHalf[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightHalf.length) {
            distances[mergedIndex] = rightHalf[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

    }

}
