package portfolioThree;

// Learning
// ________
//
// Pivot = The value used to split this part of the array.
// Last value as pivot is simple, but sorted input gives uneven splits -> O(n squared).

public class ArrayPartition {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static int partition(int[] numbers, int firstIndex, int lastIndex) {

        int pivotValue = numbers[lastIndex];
        int nextSmallerIndex = firstIndex;

        // Move values <= pivot to the front of this part of the array.
        for (int index = firstIndex; index < lastIndex; index++) {
            if (numbers[index] <= pivotValue) {
                NumberSwap.swap(numbers, index, nextSmallerIndex);
                nextSmallerIndex++;
            }
        }

        // Place pivot after the smaller values. It is now in its final position.
        NumberSwap.swap(numbers, nextSmallerIndex, lastIndex);
        return nextSmallerIndex;

    }

}
