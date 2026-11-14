package portfolioTwo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MeasurementData {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void fillNumbers(Collection<Integer> numbers, int elementCount) {

        for (int number = 0; number < elementCount; number++) {
            numbers.add(number);
        }

    }

    // _________________________________________________________________________________________________________________

    public static List<CourseTask> createTasks(int taskCount) {

        List<CourseTask> tasks = new ArrayList<>(taskCount);
        String[] taskTitles = {"Graphs", "Complexity", "Sorting", "Backtracking", "Encryption"};

        for (int taskNumber = 0; taskNumber < taskCount; taskNumber++) {
            tasks.add(new CourseTask(taskNumber, taskTitles[taskNumber % taskTitles.length]));
        }

        return tasks;

    }

}
