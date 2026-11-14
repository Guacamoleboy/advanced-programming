package portfolioThree;

import java.util.Arrays;

// Learning
// ________
//
// Base case = Fewer than 2 values. Nothing left to split.
// void is enough because merge writes back into the SAME input array.

public class MergeSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void sort(int[] numbers) {

        // Empty arrays and single values are already sorted.
        if (numbers.length < 2) {
            return;
        }

        int middleIndex = numbers.length / 2;

        // copyOfRange includes the first index, but NOT the end index.
        int[] leftHalf = Arrays.copyOfRange(numbers, 0, middleIndex);
        int[] rightHalf = Arrays.copyOfRange(numbers, middleIndex, numbers.length);

        // Sort both halves before writing their merged values back to the input.
        sort(leftHalf);
        sort(rightHalf);
        ArrayMerge.merge(numbers, leftHalf, rightHalf);

    }

}
