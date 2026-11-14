package portfolioFour;

public class MazePrinter {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void print(int[][] path) {

        for (int[] row : path) {
            for (int cell : row) {
                System.out.printf("%d ", cell);
            }
            System.out.println();
        }

    }

}
