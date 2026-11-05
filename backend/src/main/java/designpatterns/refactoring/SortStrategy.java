package designpatterns.refactoring;

import java.util.List;

/**
 * Strategy-pattern: fælles interface for alle sorteringsalgoritmer.
 * Ved at have et fælles interface kan vi udskifte algoritmen dynamisk
 * uden at ændre i koden der bruger den.
 */
public interface SortStrategy {
    void sort(List<Integer> list);
}
