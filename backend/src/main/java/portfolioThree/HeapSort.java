package portfolioThree;

// Learning
// ________
//
// A max-heap keeps its largest element at index 0.
// The children of index i are at 2i + 1 and 2i + 2. The parent is at (i - 1) / 2.

public class HeapSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public SortMeasurement sort(LocalDistance[] distances, boolean showSteps) {

        SortMeasurement measurement = new SortMeasurement();
        if (distances.length < 2) {
            return measurement;
        }

        // Build the max-heap from the last parent back to the root.
        int lastParentIndex = (distances.length - 2) / 2;
        for (int parentIndex = lastParentIndex; parentIndex >= 0; parentIndex--) {
            siftDown(distances, parentIndex, distances.length, measurement);
        }
        if (showSteps) {
            SortOutput.heap(distances, distances.length);
        }

        // Move the root to its final position, then restore the smaller heap.
        for (int lastIndex = distances.length - 1; lastIndex > 0; lastIndex--) {
            measurement.swap(distances, 0, lastIndex);
            siftDown(distances, 0, lastIndex, measurement);
            if (showSteps) {
                SortOutput.heapAfterSwap(distances, lastIndex);
            }
        }

        return measurement;

    }

    // _________________________________________________________________________________________________________________

    private void siftDown(LocalDistance[] distances, int parentIndex, int heapSize,
                          SortMeasurement measurement) {

        // Only indices in the first half of the heap can have children.
        while (parentIndex < heapSize / 2) {
            int leftIndex = 2 * parentIndex + 1;
            int rightIndex = leftIndex + 1;
            int largerChildIndex = leftIndex;

            if (rightIndex < heapSize && measurement.compare(distances[rightIndex], distances[leftIndex]) > 0) {
                largerChildIndex = rightIndex;
            }

            if (measurement.compare(distances[parentIndex], distances[largerChildIndex]) >= 0) {
                return;
            }

            measurement.swap(distances, parentIndex, largerChildIndex);
            parentIndex = largerChildIndex;
        }

    }

}
