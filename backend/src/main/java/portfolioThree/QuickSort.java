package portfolioThree;

public class QuickSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void sort(int[] numbers, int first, int last) {
        if (first >= last) {
            return;
        }
        // Pivot is in its final position. Sort the values on either side.
        int pivotIndex = ArrayPartition.partition(numbers, first, last);
        sort(numbers, first, pivotIndex - 1);
        sort(numbers, pivotIndex + 1, last);
    }

}
