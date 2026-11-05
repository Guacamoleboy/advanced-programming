package portfolioOne;

import java.util.ArrayList;
import java.util.List;

public class GridMap {

    // Attributes
    private final GridNode[][] nodes;

    // 0 is road
    // 1 is closed cell
    public GridMap(int[][] layout) {

        // Open cell = node
        // Remaining cells = null
        nodes = new GridNode[layout.length][layout[0].length];
        for (int row = 0; row < layout.length; row++) {
            for (int col = 0; col < layout[row].length; col++) {
                if (layout[row][col] == 0) {
                    nodes[row][col] = new GridNode(row, col);
                }
            }
        }

    }

    // _________________________________________________________________________________________________________________

    public void placeCity(City city, int row, int col) {
        if (nodes[row][col] == null) {
            throw new IllegalArgumentException("A city must be placed on an open cell.");
        }
        nodes[row][col].setCity(city);
    }

    // _________________________________________________________________________________________________________________

    public List<GridNode> getCityNodes() {
        List<GridNode> cities = new ArrayList<>();
        for (GridNode[] row : nodes) {
            for (GridNode node : row) {
                if (node != null && node.getCity() != null) {
                    cities.add(node);
                }
            }
        }
        return cities;
    }

    // _________________________________________________________________________________________________________________

    public GridNode getCityNode(String name) {
        for (GridNode node : getCityNodes()) {
            if (node.getCity().getName().equals(name)) {
                return node;
            }
        }
        throw new IllegalArgumentException("City is not found in the grid system: " + name);
    }

    // _________________________________________________________________________________________________________________

    public List<GridNode> getNeighbors(GridNode node) {
        List<GridNode> neighbors = new ArrayList<>();

        // Up, down, left, right. No diagonal moves.
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int row = node.getRow() + direction[0];
            int col = node.getCol() + direction[1];

            // Check the bounds before looking up the cell.
            if (row >= 0 && row < nodes.length && col >= 0 && col < nodes[0].length
                    && nodes[row][col] != null) {
                neighbors.add(nodes[row][col]);
            }

        }
        return neighbors;
    }

}