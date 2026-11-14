package portfolioFour;

public class MazePrinter {

    // Attributes

    // _________________________________________________________________________________________________________________

    public void print(int[][] path) {
        for (int[] row : path) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}
