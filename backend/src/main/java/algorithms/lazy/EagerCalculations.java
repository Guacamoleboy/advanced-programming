package algorithms.lazy;

import java.util.HashMap;
import java.util.Map;

public class EagerCalculations {
    static Map<Integer, Long> memo = new HashMap<>();

    static{
        // beregn fakultet for alle tal fx op til 50 og læg det i map
        memo.put(1,1L);
        for(int i = 2; i <= 50; i++){
                memo.put(i, i * memo.get(i-1));
        }
    }


    public static long eagerFactorial(int n) {

            return memo.get(n); // allerede beregnet? returnér resultatet

    }


}

