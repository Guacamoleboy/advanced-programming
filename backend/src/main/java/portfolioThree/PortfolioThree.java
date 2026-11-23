package portfolioThree;

public class PortfolioThree {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void main(String[] args) {

        LocalDistance[] shuffled = DistanceData.shuffledCopy(DistanceData.createDistances());
        LocalDistance[] sorted = DistanceData.sortedCopy(shuffled);
        LocalDistance[] reversed = DistanceData.reversedCopy(sorted);

        compareSorts("Shuffled input", shuffled, true);
        compareSorts("Sorted input", sorted, false);
        compareSorts("Reverse-sorted input", reversed, false);

        System.out.println("\nQuick Sort on sorted input");
        comparePivots(sorted, true);
        comparePivots(DistanceData.repeatSorted(sorted, 10), false);
        comparePivots(DistanceData.repeatSorted(sorted, 40), false);

    }

    // _________________________________________________________________________________________________________________

    private static void compareSorts(String title, LocalDistance[] input, boolean showSteps) {

        SortOutput.input(title, input);

        SortOutput.stepHeading("Bubble Sort", showSteps);
        LocalDistance[] bubbleDistances = input.clone();
        SortMeasurement bubbleMeasurement = new BubbleSort().sort(bubbleDistances, showSteps);
        SortOutput.result("Bubble Sort", bubbleDistances, bubbleMeasurement, true);

        SortOutput.stepHeading("Merge Sort", showSteps);
        LocalDistance[] mergeDistances = input.clone();
        SortMeasurement mergeMeasurement = new MergeSort().sort(mergeDistances, showSteps);
        SortOutput.result("Merge Sort", mergeDistances, mergeMeasurement, false);

        SortOutput.stepHeading("Quick Sort", showSteps);
        LocalDistance[] quickDistances = input.clone();
        SortMeasurement quickMeasurement = new QuickSort().sort(quickDistances, showSteps);
        SortOutput.result("Quick Sort", quickDistances, quickMeasurement, true);

        SortOutput.stepHeading("Heap Sort", showSteps);
        LocalDistance[] heapDistances = input.clone();
        SortMeasurement heapMeasurement = new HeapSort().sort(heapDistances, showSteps);
        SortOutput.result("Heap Sort", heapDistances, heapMeasurement, false);

    }

    // _________________________________________________________________________________________________________________

    private static void comparePivots(LocalDistance[] sorted, boolean showSteps) {

        QuickSort quickSort = new QuickSort();
        System.out.printf("%n%d elements%n", sorted.length);
        System.out.println("Last element as pivot");
        SortMeasurement lastPivot = quickSort.sort(sorted.clone(), showSteps);
        SortOutput.measurement(lastPivot, true);

        System.out.println("Middle element as pivot");
        SortMeasurement middlePivot = quickSort.sortWithMiddlePivot(sorted.clone(), showSteps);
        SortOutput.measurement(middlePivot, true);

    }

}
