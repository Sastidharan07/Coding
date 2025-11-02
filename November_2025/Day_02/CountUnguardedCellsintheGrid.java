//Question : https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        for (int[] guard : guards) grid[guard[0]][guard[1]] = 1;
        for (int[] wall : walls) grid[wall[0]][wall[1]] = 2;
    
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            
            for (int r = row - 1; r >= 0; r--) {
                if (grid[r][col] == 1 || grid[r][col] == 2) break; 
                if (grid[r][col] == 0) grid[r][col] = 3; 
            }

            for (int r = row + 1; r < m; r++) {
                if (grid[r][col] == 1 || grid[r][col] == 2) break;
                if (grid[r][col] == 0) grid[r][col] = 3;
            }
            
            for (int c = col - 1; c >= 0; c--) {
                if (grid[row][c] == 1 || grid[row][c] == 2) break;
                if (grid[row][c] == 0) grid[row][c] = 3;
            }
            
            for (int c = col + 1; c < n; c++) {
                if (grid[row][c] == 1 || grid[row][c] == 2) break;
                if (grid[row][c] == 0) grid[row][c] = 3;
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}