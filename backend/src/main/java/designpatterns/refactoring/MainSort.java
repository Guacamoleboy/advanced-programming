package designpatterns.refactoring;

/**
 * Sammenlign med den originale Main:
 *
 * Originalt:
 *   testBubble(10000);  // copy-paste af samme skelet 4 gange
 *   testQuick(10000);
 *   ...
 *
 * Refaktoreret med Strategy:
 *   Skelettet er defineret ét sted (SortTest).
 *   Algoritmen er udskiftelig (SortStrategy).
 *   Ny sorteringsalgoritme = ny klasse, ingen ændring i Main.
 */
public class MainSort {

    public static void main(String[] args) {
        int size = 10000;

        SortTest sortTest = new SortTest(new BubbleSortStrategy());
        sortTest.run(size);
        System.out.println("-----------------------------------------");
        sortTest.setStrategy(new QuickSortStrategy());
        sortTest.run(size);
    }
}