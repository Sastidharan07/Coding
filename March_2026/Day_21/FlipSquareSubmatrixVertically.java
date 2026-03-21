//Question : https://leetcode.com/problems/flip-square-submatrix-vertically/description/
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i = 0; i < k / 2; i++) {
            for(int j = y; j < y + k; j++) {
                int temp = grid[x + i][j];
                grid[x + i][j] = grid[x + k - 1 - i][j];
                grid[x + k - 1 - i][j] = temp;
            }
        }
        return grid;
    }
}