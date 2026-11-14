package portfolioFour;

public class PortfolioFour {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void main(String[] args) {
        int[][] maze = MazeData.createMaze();
        int[][] path = new int[maze.length][maze[0].length];

        if (new MazeSolver().solveMaze(maze, path, 0, 0)) {
            System.out.println("Sti fra øverste venstre til nederste højre hjørne:");
            new MazePrinter().print(path);
        } else {
            System.out.println("Ingen løsning fundet.");
        }
    }

}
