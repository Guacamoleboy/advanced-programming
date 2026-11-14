package portfolioThree;

public class ArrayPartition {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static int partition(int[] numbers, int first, int last) {
        int pivot = numbers[last];
        int smallerEnd = first;

        // Move values <= pivot to the front of this part of the array.
        for (int index = first; index < last; index++) {
            if (numbers[index] <= pivot) {
                NumberSwap.swap(numbers, index, smallerEnd);
                smallerEnd++;
            }
        }
        NumberSwap.swap(numbers, smallerEnd, last);
        return smallerEnd;
    }

}
