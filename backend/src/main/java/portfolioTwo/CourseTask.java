package portfolioTwo;

// Learning
// ________
//
// TreeSet uses compareTo. HashSet uses hashCode and equals.
// All three use taskNumber, so both sets agree on what counts as the SAME task.

public final class CourseTask implements Comparable<CourseTask> {

    // Attributes
    private final int taskNumber;
    private final String taskTitle;

    // _________________________________________________________________________________________________________________

    public CourseTask(int taskNumber, String taskTitle) {

        this.taskNumber = taskNumber;
        this.taskTitle = taskTitle;

    }

    // _________________________________________________________________________________________________________________

    @Override
    public int compareTo(CourseTask comparedTask) {

        return Integer.compare(taskNumber, comparedTask.taskNumber);

    }

    // _________________________________________________________________________________________________________________

    @Override
    public boolean equals(Object comparedObject) {

        // instanceof checks the type and gives us comparedTask before we use its number.
        return comparedObject instanceof CourseTask comparedTask && taskNumber == comparedTask.taskNumber;

    }

    // _________________________________________________________________________________________________________________

    @Override
    public int hashCode() {

        return Integer.hashCode(taskNumber);

    }

    // _________________________________________________________________________________________________________________

    @Override
    public String toString() {

        return String.format("%d: %s", taskNumber, taskTitle);

    }

}
