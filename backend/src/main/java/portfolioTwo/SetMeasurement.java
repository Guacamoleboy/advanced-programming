package portfolioTwo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetMeasurement {

    // Attributes
    private static final int TASK_COUNT = 10_000;

    // _________________________________________________________________________________________________________________

    public void run() {

        List<CourseTask> tasks = MeasurementData.createTasks(TASK_COUNT);
        System.out.printf("%nCourse tasks per set: %d%n", TASK_COUNT);

        for (int round = 1; round <= 3; round++) {

            System.out.println();
            System.out.printf("Sets - round %d%n", round);
            if (round == 1) {
                System.out.println("Warm-up");
            }

            for (Set<CourseTask> taskSet : List.<Set<CourseTask>>of(new TreeSet<>(), new HashSet<>())) {

                String setName = taskSet.getClass().getSimpleName();

                OperationTiming.measure(setName, "Add all course tasks", 1, () -> {
                    for (CourseTask task : tasks) {
                        taskSet.add(task);
                    }
                });

                OperationTiming.measure(setName, "Find all course tasks", 1, () -> {
                    for (CourseTask task : tasks) {
                        OperationTiming.consume(taskSet.contains(task));
                    }
                });

                // A new object with the same number must still count as the same task.
                CourseTask matchingTask = new CourseTask(2, "Same task number, new instance");
                System.out.printf("Find task 2 using a new instance: %b%n", taskSet.contains(matchingTask));
                System.out.printf("Add duplicate task 2: %b%n", taskSet.add(matchingTask));

                OperationTiming.measure(setName, "Remove all course tasks", 1, () -> {
                    for (CourseTask task : tasks) {
                        taskSet.remove(task);
                    }
                });

                System.out.printf("Find task 2 after removal: %b%n", taskSet.contains(matchingTask));

            }

        }

    }

}
