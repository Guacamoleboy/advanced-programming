package algorithms.lazy;

import java.util.HashMap;
import java.util.Map;

public class LazySums {
    Map<Integer, Integer> sums = new HashMap();

    public int getSum(int n){
        if (sums.containsKey(n)) {
            return sums.get(n);
        }
        if(n == 0){
            sums.put(n,0);
            return 0;
        }
        int result = n;
        result += getSum(n-1);
        sums.put(n, result);
        return result;


    }




}
