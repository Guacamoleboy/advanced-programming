package portfolioThree;

import java.util.Arrays;

public class PortfolioThree {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void main(String[] args) {
        int[] distances = LocalDistances.createDistances();
        int[] bubbleNumbers = distances.clone();
        int[] mergeNumbers = distances.clone();
        int[] quickNumbers = distances.clone();

        System.out.println("Forenklede afstandstal fra Hillerød: " + Arrays.toString(distances));
        new BubbleSort().sort(bubbleNumbers);
        new MergeSort().sort(mergeNumbers);
        new QuickSort().sort(quickNumbers, 0, quickNumbers.length - 1);
        System.out.println("Bubble sort: " + Arrays.toString(bubbleNumbers));
        System.out.println("Merge sort: " + Arrays.toString(mergeNumbers));
        System.out.println("Quick sort: " + Arrays.toString(quickNumbers));

        int[] sortedNumbers = mergeNumbers.clone();
        new QuickSort().sort(sortedNumbers, 0, sortedNumbers.length - 1);
        System.out.println("Quick sort med allerede sorteret input: " + Arrays.toString(sortedNumbers));
    }

}
