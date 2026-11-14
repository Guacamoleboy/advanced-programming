package portfolioThree;

public class ArrayMerge {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void merge(int[] destination, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int destinationIndex = 0;

        // Take the smallest next value. On a tie, take the left one first.
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                destination[destinationIndex++] = left[leftIndex++];
            } else {
                destination[destinationIndex++] = right[rightIndex++];
            }
        }
        // Copy the remaining values from the half that is not empty yet.
        while (leftIndex < left.length) {
            destination[destinationIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            destination[destinationIndex++] = right[rightIndex++];
        }
    }

}
