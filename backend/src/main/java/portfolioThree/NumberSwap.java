package portfolioThree;

public class NumberSwap {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void swap(int[] numbers, int first, int second) {
        int temporary = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temporary;
    }

}
