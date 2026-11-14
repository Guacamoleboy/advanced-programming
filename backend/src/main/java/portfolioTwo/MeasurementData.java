package portfolioTwo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MeasurementData {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void fillNumbers(Collection<Integer> numbers, int count) {
        for (int number = 0; number < count; number++) {
            numbers.add(number);
        }
    }

    // _________________________________________________________________________________________________________________

    public static List<CourseTask> createTasks(int count) {
        List<CourseTask> tasks = new ArrayList<>(count);
        String[] topics = {"Grafer", "Kompleksitet", "Sortering", "Backtracking", "Kryptering"};
        for (int number = 0; number < count; number++) {
            tasks.add(new CourseTask(number, topics[number % topics.length]));
        }
        return tasks;
    }

}
