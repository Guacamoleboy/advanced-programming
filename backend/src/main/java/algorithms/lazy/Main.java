package algorithms.lazy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(EagerCalculations.eagerFactorial(5));  // udregner og gemmer
        System.out.println(EagerCalculations.eagerFactorial(4));  // bliver hurtigt, fordi det allerede er gemt
        System.out.println(EagerCalculations.eagerFactorial(6));
        System.out.println(EagerCalculations.eagerFactorial(49)); // bruger gemt factorial(5)
    }
}
