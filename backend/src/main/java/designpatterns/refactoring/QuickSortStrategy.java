package designpatterns.refactoring;

import java.util.Collections;
import java.util.List;

/**
 * Strategy: Quick Sort implementering.
 * O(n log n) gennemsnitligt — hurtig i praksis.
 */
public class QuickSortStrategy implements SortStrategy {

    @Override
    public void sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }

    private int partition(List<Integer> list, int low, int high) {
        int pivotValue = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivotValue) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}
