package portfolioThree;

public class ArrayMerge {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void merge(int[] numbers, int[] leftHalf, int[] rightHalf) {

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        // Take the smallest next value. On a tie, take the left one first.
        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                numbers[mergedIndex] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                numbers[mergedIndex] = rightHalf[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // Copy the remaining values from the half that is not empty yet.
        while (leftIndex < leftHalf.length) {
            numbers[mergedIndex] = leftHalf[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightHalf.length) {
            numbers[mergedIndex] = rightHalf[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

    }

}
