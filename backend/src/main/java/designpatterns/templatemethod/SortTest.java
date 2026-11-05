package designpatterns.templatemethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SortTest {

    // Skabelonen – kaldt rækkefølgen må ikke ændres
    public final void run(int size) {
        List<Integer> list = createList(size);
        prepare(list);
        long start = System.currentTimeMillis();
        sort(list);
        long stop = System.currentTimeMillis();
        report(stop - start);
    }

    // Trin 1: Opret liste med tilfældige tal
    protected List<Integer> createList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * size));
        }
        return list;
    }

    // Trin 2: Forbered listen (kan overrides af subklasse)
    protected void prepare(List<Integer> list) {
        Collections.shuffle(list);
    }

    // Trin 3: Det variable trin – subklassen bestemmer algoritmen
    protected abstract void sort(List<Integer> list);

    // Trin 4: Rapportér resultatet
    protected void report(long ms) {
        System.out.println(getClass().getSimpleName() + " tog: " + ms + " ms");
    }
}
