package portfolioFour;

public class PortfolioFour {

    // Attributes

    // _________________________________________________________________________________________________________________

    public static void main(String[] args) {

        int[][] maze = MazeData.createMaze();
        int[][] path = new int[maze.length][maze[0].length];

        if (new MazeSolver().solveMaze(maze, path, 0, 0)) {
            System.out.println("Path from the top left to the bottom right:");
            new MazePrinter().print(path);
        } else {
            System.out.println("No path found.");
        }

    }

}
