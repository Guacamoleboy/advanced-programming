package portfolioThree;

import java.util.Arrays;

public class MergeSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void sort(int[] numbers) {
        // Empty arrays and single values are already sorted.
        if (numbers.length < 2) {
            return;
        }
        int middle = numbers.length / 2;
        int[] left = Arrays.copyOfRange(numbers, 0, middle);
        int[] right = Arrays.copyOfRange(numbers, middle, numbers.length);

        // Sort both halves before writing their merged values back to the input.
        sort(left);
        sort(right);
        ArrayMerge.merge(numbers, left, right);
    }

}
