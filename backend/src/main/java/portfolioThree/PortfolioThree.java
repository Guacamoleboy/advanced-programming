package portfolioThree;

import java.util.Arrays;

public class PortfolioThree {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void main(String[] args) {

        int[] distances = LocalDistance.createDistances();

        // Each algorithm needs its OWN copy, otherwise the next one gets sorted input.
        int[] bubbleNumbers = distances.clone();
        int[] mergeNumbers = distances.clone();
        int[] quickNumbers = distances.clone();

        System.out.printf("Example distances from Hillerød: %s%n", Arrays.toString(distances));

        new BubbleSort().sort(bubbleNumbers);
        new MergeSort().sort(mergeNumbers);
        new QuickSort().sort(quickNumbers, 0, quickNumbers.length - 1);

        System.out.printf("Bubble sort: %s%n", Arrays.toString(bubbleNumbers));
        System.out.printf("Merge sort: %s%n", Arrays.toString(mergeNumbers));
        System.out.printf("Quick sort: %s%n", Arrays.toString(quickNumbers));

        int[] sortedNumbers = mergeNumbers.clone();
        new QuickSort().sort(sortedNumbers, 0, sortedNumbers.length - 1);
        System.out.printf("Quick sort with sorted input: %s%n", Arrays.toString(sortedNumbers));

    }

}
