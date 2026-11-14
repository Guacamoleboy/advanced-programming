package portfolioTwo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SearchMeasurement {

    // Attributes
    private static final int ELEMENT_COUNT = 500_000;

    // _________________________________________________________________________________________________________________

    public void run() {

        for (int round = 1; round <= 3; round++) {

            System.out.println();
            System.out.printf("Search - round %d%n", round);
            if (round == 1) {
                System.out.println("Warm-up");
            }

            List<Integer> numbers = new ArrayList<>(ELEMENT_COUNT);
            MeasurementData.fillNumbers(numbers, ELEMENT_COUNT);

            for (Collection<Integer> collection : List.<Collection<Integer>>of(numbers, new HashSet<>(numbers))) {

                String collectionName = collection.getClass().getSimpleName();

                // First value, last value and a value that is NOT in the collection.
                for (int searchValue : new int[]{0, ELEMENT_COUNT - 1, -1}) {
                    String operationName = String.format("Find value %d", searchValue);
                    OperationTiming.measure(collectionName, operationName, 100,
                            () -> OperationTiming.consume(collection.contains(searchValue)));
                }

            }

        }

    }

}
