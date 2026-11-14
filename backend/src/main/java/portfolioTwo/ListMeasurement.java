package portfolioTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMeasurement {

    // Attributes
    private static final int ELEMENT_COUNT = 500_000;
    private static final int MIDDLE_INDEX = 250_000;

    // _________________________________________________________________________________________________________________

    public void run() {

        // First round warms up the JVM. Each round starts with new lists.
        for (int round = 1; round <= 3; round++) {

            System.out.println();
            System.out.printf("Lists - round %d%n", round);
            if (round == 1) {
                System.out.println("Warm-up");
            }

            for (List<Integer> numbers : List.<List<Integer>>of(
                    new ArrayList<>(ELEMENT_COUNT + 10_000), new LinkedList<>())) {

                MeasurementData.fillNumbers(numbers, ELEMENT_COUNT);
                String listName = numbers.getClass().getSimpleName();

                OperationTiming.measure(listName, "Read middle element", 100,
                        () -> OperationTiming.consume(numbers.get(MIDDLE_INDEX)));
                OperationTiming.measure(listName, "Insert 99 in the middle", 1,
                        () -> numbers.add(MIDDLE_INDEX, 99));
                // Remove the inserted 99, so the list has 500,000 elements again.
                OperationTiming.measure(listName, "Remove middle element", 1,
                        () -> OperationTiming.consume(numbers.remove(MIDDLE_INDEX)));
                OperationTiming.measure(listName, "Insert 99 at the front", 10_000,
                        () -> numbers.add(0, 99));

            }

        }

    }

}
