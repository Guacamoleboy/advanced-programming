package portfolioThree;

public class BubbleSort {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void sort(int[] numbers) {
        // Each pass puts the largest remaining number at the unsorted end.
        for (int unsortedEnd = numbers.length - 1; unsortedEnd > 0; unsortedEnd--) {
            boolean swapped = false;
            for (int index = 0; index < unsortedEnd; index++) {
                if (numbers[index] > numbers[index + 1]) {
                    NumberSwap.swap(numbers, index, index + 1);
                    swapped = true;
                }
            }
            // No swaps means the entire array is already sorted.
            if (!swapped) {
                return;
            }
        }
    }

}
