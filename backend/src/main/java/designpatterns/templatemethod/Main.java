package designpatterns.templatemethod;

public class Main {

    public static void main(String[] args) {
        int size = 10000;

        SortTest bubble = new BubbleSortTest();
        bubble.run(size);

        SortTest quick = new QuickSortTest();
        quick.run(size);
    }
}
