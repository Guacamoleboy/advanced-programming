package portfolioTwo;

// Learning
// ________
//
// nanoTime is required in the task. Some operations take less than 1 ms.
// elapsedTime = stop - start. The result is in nanoseconds, not milliseconds.
// Runnable = The operation we want to repeat and measure.

public class OperationTiming {

    // Attributes
    private static volatile Object operationResult;

    // _________________________________________________________________________________________________________________

    public static void measure(String collectionName, String operationName, int repetitions, Runnable operation) {

        long startTime = System.nanoTime();

        // Measure the full loop because one lookup can be too quick on its own.
        for (int repetition = 0; repetition < repetitions; repetition++) {
            operation.run();
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.printf("%s - %s: %d ns, repetitions: %d%n", collectionName, operationName, elapsedTime, repetitions);

    }

    // _________________________________________________________________________________________________________________

    public static void consume(Object measuredResult) {

        // volatile keeps the result visible to the JVM, so an unused lookup is not removed.
        operationResult = measuredResult;

    }

}
