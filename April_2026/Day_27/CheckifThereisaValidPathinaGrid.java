//Question : https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/description/
class Solution {
    int rows, cols;
    // Map street types to their 2 valid exit directions: {rowOffset, colOffset}
    int[][][] dir = {
        {}, 
        {{0, -1}, {0, 1}},  // 1: Left, Right
        {{-1, 0}, {1, 0}},  // 2: Up, Down
        {{0, -1}, {1, 0}},  // 3: Left, Down
        {{0, 1}, {1, 0}},   // 4: Right, Down
        {{0, -1}, {-1, 0}}, // 5: Left, Up
        {{0, 1}, {-1, 0}}   // 6: Right, Up
    };

    public boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited) {
        // Base case: reached the bottom-right corner
        if (row == rows - 1 && col == cols - 1) return true;

        visited[row][col] = true;
        int streetType = grid[row][col];

        // Explore the two possible exits for the current street type
        for (int[] d : dir[streetType]) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            // 1. Boundary Check & Visited Check
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                && !visited[newRow][newCol]) {
                
                // 2. Handshake Check: Does the neighbor connect back to the current cell?
                if (canConnect(row, col, newRow, newCol, grid[newRow][newCol])) {
                    if (dfs(grid, newRow, newCol, visited)) return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the street at (row, col) has an exit that leads back to (parentRow, parentCol)
     */
    private boolean canConnect(int parentRow, int parentCol, int row, int col, int neighType) {
        for (int[] d : dir[neighType]) {
            if (row + d[0] == parentRow && col + d[1] == parentCol) {
                return true;
            }
        }
        return false;
    }
}