package designpatterns.refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Strategy: sorteringsalgoritmen injiceres i konstruktøren og kan skiftes frit.
 */

public class SortTest {

    private SortStrategy strategy;

    public SortTest(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy){
        this.strategy = strategy;
    }

    public void run(int size) {
        List<Integer> list = createList(size);
        prepare(list);
        long start = System.currentTimeMillis();
        strategy.sort(list);
        long stop = System.currentTimeMillis();
        report(stop - start);
    }

    private List<Integer> createList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * size));
        }
        return list;
    }

    private void prepare(List<Integer> list) {
        Collections.shuffle(list);
    }

    private void report(long ms) {
        System.out.println(strategy.getClass().getSimpleName() + " tog: " + ms + " ms");
    }
}