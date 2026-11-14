package portfolioThree;

public class QuickSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void sort(int[] numbers, int firstIndex, int lastIndex) {

        // Zero or one value in this part of the array. Stop the recursion.
        if (firstIndex >= lastIndex) {
            return;
        }

        // Pivot is in its final position. Sort the values on either side.
        int pivotIndex = ArrayPartition.partition(numbers, firstIndex, lastIndex);
        sort(numbers, firstIndex, pivotIndex - 1);
        sort(numbers, pivotIndex + 1, lastIndex);

    }

}
