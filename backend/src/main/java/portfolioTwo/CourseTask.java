package portfolioTwo;

public final class CourseTask implements Comparable<CourseTask> {

    // Attributes
    private final int number;
    private final String title;

    // _________________________________________________________________________________________________________________

    public CourseTask(int number, String title) {
        this.number = number;
        this.title = title;
    }

    // _________________________________________________________________________________________________________________

    @Override
    public int compareTo(CourseTask other) {
        return Integer.compare(number, other.number);
    }

    // _________________________________________________________________________________________________________________

    @Override
    public boolean equals(Object other) {
        return other instanceof CourseTask task && number == task.number;
    }

    // _________________________________________________________________________________________________________________

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    // _________________________________________________________________________________________________________________

    @Override
    public String toString() {
        return number + ": " + title;
    }

}
