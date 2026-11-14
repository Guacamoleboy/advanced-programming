package portfolioFour;

// Learning
// ________
//
// maze: 1 = open, 0 = wall. path: 1 = part of the CURRENT route.
// Backtracking = Try a direction, then undo the choice if it leads nowhere.
// First route found. Not necessarily the shortest one.

public class MazeSolver {

    // Attributes

    // _________________________________________________________________________________________________________________

    public boolean solveMaze(int[][] maze, int[][] path, int row, int column) {

        // Check bounds FIRST, then reject walls and cells already on this route.
        if (row < 0 || row >= maze.length || column < 0 || column >= maze[row].length
                || maze[row][column] != 1 || path[row][column] == 1) {
            return false;
        }

        path[row][column] = 1;
        if (row == maze.length - 1 && column == maze[row].length - 1) {
            return true;
        }

        // Try down, right, up, left. Stop when one direction reaches the goal.
        if (solveMaze(maze, path, row + 1, column)
                || solveMaze(maze, path, row, column + 1)
                || solveMaze(maze, path, row - 1, column)
                || solveMaze(maze, path, row, column - 1)) {
            return true;
        }

        // Dead end. Remove this cell from the path before going back.
        path[row][column] = 0;
        return false;

    }

}
