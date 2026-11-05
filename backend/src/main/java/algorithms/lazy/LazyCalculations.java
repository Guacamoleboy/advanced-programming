package algorithms.lazy;

import java.util.HashMap;
import java.util.Map;

public class LazyCalculations {
    static Map<Integer, Long> memo = new HashMap<>();

    public static long lazyFactorial(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n); // allerede beregnet? returnér resultatet
        }

        long result;
        if (n == 0 || n == 1) {
            result = 1;
        } else {
            result = n * lazyFactorial(n - 1);
        }

        memo.put(n, result); // gem til næste gang
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lazyFactorial(5));  // udregner og gemmer
        System.out.println(lazyFactorial(4));  // bliver hurtigt, fordi det allerede er gemt
        System.out.println(lazyFactorial(6));  // bruger gemt factorial(5)
    }
}

