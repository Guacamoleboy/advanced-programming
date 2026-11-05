package designpatterns.strategy;

import java.util.List;

public class BubbleSort implements SortStrategy {
    public void sort(List<Integer> data) {
        System.out.println("Sorting with BubbleSort");
    }
}