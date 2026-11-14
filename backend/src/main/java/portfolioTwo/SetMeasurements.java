package portfolioTwo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetMeasurements {

    // Attributes
    private static final int TASK_COUNT = 10_000;

    // _________________________________________________________________________________________________________________

    public void run() {
        List<CourseTask> tasks = MeasurementData.createTasks(TASK_COUNT);
        for (int round = 1; round <= 3; round++) {
            System.out.println("\nSæt, runde " + round + (round == 1 ? " (opvarmning)" : ""));
            for (Set<CourseTask> taskSet : List.<Set<CourseTask>>of(new TreeSet<>(), new HashSet<>())) {
                String label = taskSet.getClass().getSimpleName();
                OperationTiming.measure(label + " add, " + TASK_COUNT + " objekter", 1, () -> {
                    for (CourseTask task : tasks) {
                        taskSet.add(task);
                    }
                });
                OperationTiming.measure(label + " contains, " + TASK_COUNT + " objekter", 1, () -> {
                    for (CourseTask task : tasks) {
                        OperationTiming.consume(taskSet.contains(task));
                    }
                });
                CourseTask sameTask = new CourseTask(2, "Samme nummer, ny instans");
                System.out.println("Finder ny instans med nummer 2: " + taskSet.contains(sameTask));
                System.out.println("Tilføjer dublet med nummer 2: " + taskSet.add(sameTask));
                OperationTiming.measure(label + " remove, " + TASK_COUNT + " objekter", 1, () -> {
                    for (CourseTask task : tasks) {
                        taskSet.remove(task);
                    }
                });
                System.out.println("Finder nummer 2 efter fjernelse: " + taskSet.contains(sameTask));
            }
        }
    }

}
