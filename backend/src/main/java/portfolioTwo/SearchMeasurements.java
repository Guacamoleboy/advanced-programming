package portfolioTwo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SearchMeasurements {

    // Attributes
    private static final int ELEMENT_COUNT = 500_000;

    // _________________________________________________________________________________________________________________

    public void run() {
        for (int round = 1; round <= 3; round++) {
            System.out.println("\nSøgning, runde " + round + (round == 1 ? " (opvarmning)" : ""));
            List<Integer> numbers = new ArrayList<>(ELEMENT_COUNT);
            MeasurementData.fillNumbers(numbers, ELEMENT_COUNT);
            for (Collection<Integer> collection : List.<Collection<Integer>>of(numbers, new HashSet<>(numbers))) {
                for (int target : new int[]{0, ELEMENT_COUNT - 1, -1}) {
                    OperationTiming.measure(collection.getClass().getSimpleName() + " contains(" + target + ")", 100,
                            () -> OperationTiming.consume(collection.contains(target)));
                }
            }
        }
    }

}
