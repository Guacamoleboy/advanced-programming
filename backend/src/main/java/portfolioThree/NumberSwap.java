package portfolioThree;

public class NumberSwap {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void swap(int[] numbers, int firstIndex, int secondIndex) {

        int savedNumber = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = savedNumber;

    }

}
