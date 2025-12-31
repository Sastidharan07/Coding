//Question : https://leetcode.com/problems/magic-squares-in-grid/description/
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (rows < 3 || cols < 3) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (is_magic_square(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean is_magic_square(int[][] grid, int row, int col) {
        if (grid[row + 1][col + 1] != 5) {
            return false;
        }
        
        if (grid[row][col] % 2 != 0 || 
            grid[row][col + 2] % 2 != 0 || 
            grid[row + 2][col] % 2 != 0 || 
            grid[row + 2][col + 2] % 2 != 0) { 
            return false;
        }
        
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != 15) {
            return false;
        }
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != 15) {
            return false;
        }
        
        boolean[] seen = new boolean[16]; 
        
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != 15) {
                return false;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (grid[row][col + j] + grid[row + 1][col + j] + grid[row + 2][col + j] != 15) {
                return false;
            }
        }
        
        return true;
    }
}