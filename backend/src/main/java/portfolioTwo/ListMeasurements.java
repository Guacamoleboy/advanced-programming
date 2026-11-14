package portfolioTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMeasurements {

    // Attributes
    private static final int ELEMENT_COUNT = 500_000;
    private static final int MIDDLE_INDEX = 250_000;

    // _________________________________________________________________________________________________________________

    public void run() {
        for (int round = 1; round <= 3; round++) {
            System.out.println("\nLister, runde " + round + (round == 1 ? " (opvarmning)" : ""));
            for (List<Integer> numbers : List.<List<Integer>>of(
                    new ArrayList<>(ELEMENT_COUNT + 10_000), new LinkedList<>())) {
                MeasurementData.fillNumbers(numbers, ELEMENT_COUNT);
                String label = numbers.getClass().getSimpleName();
                OperationTiming.measure(label + " get(250000)", 100,
                        () -> OperationTiming.consume(numbers.get(MIDDLE_INDEX)));
                OperationTiming.measure(label + " add(250000, 99)", 1,
                        () -> numbers.add(MIDDLE_INDEX, 99));
                OperationTiming.measure(label + " remove(250000)", 1,
                        () -> OperationTiming.consume(numbers.remove(MIDDLE_INDEX)));
                OperationTiming.measure(label + " add(0, 99)", 10_000,
                        () -> numbers.add(0, 99));
            }
        }
    }

}
