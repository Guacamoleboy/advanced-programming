package portfolioTwo;

public class OperationTiming {

    // Attributes
    private static volatile Object result;

    // _________________________________________________________________________________________________________________

    public static void measure(String label, int repetitions, Runnable operation) {
        long start = System.nanoTime();
        for (int repetition = 0; repetition < repetitions; repetition++) {
            operation.run();
        }
        long elapsed = System.nanoTime() - start;
        System.out.println(label + ": " + elapsed + " ns (" + repetitions + " kald)");
    }

    // _________________________________________________________________________________________________________________

    public static void consume(Object value) {
        // Keep the result so the JVM cannot simply discard the lookup.
        result = value;
    }

}
