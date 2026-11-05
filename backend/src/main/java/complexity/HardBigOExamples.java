package complexity;

import java.util.List;
import java.util.Set;

/**
 * Hvad er kompleksiteten for hver metode?
 * Begrund dit svar: Hvad sker der med arbejdet, hvis n bliver 1000 gange større?
 */
public class HardBigOExamples {

    // 1
    public static int sumTwice(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    // 2
    public static int sumFirstTen(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < 10 && i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    // 3
    public static int sumFirstHalf(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length / 2; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    // 4
    public static int countPairs(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 5
    public static int countCommon(List<Integer> first, List<Integer> second) {
        int count = 0;
        for (Integer number : first) {
            if (second.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 6
    public static int countCommon(List<Integer> first, Set<Integer> second) {
        int count = 0;
        for (Integer number : first) {
            if (second.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 7
    public static int doublingInside(int n) {
        int steps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                steps++;
            }
        }
        return steps;
    }

    // 8
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
