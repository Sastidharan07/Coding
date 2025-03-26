//Question : https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
class Solution {
    public int minOperations(int[][] grid, int x) {
        int row = grid.length;
        int col = grid[0].length;

        int[] flatten = new int[row * col];
        int idx = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flatten[idx] = grid[i][j];
                idx++;
            }
        }
        int remainder = flatten[0] % x;
        for (int i = 0; i < flatten.length; i++) {
            if (flatten[i] % x != remainder) {
                return -1;
            }
        }
        Arrays.sort(flatten);
        int median = flatten[row * col / 2];
        int step = 0;
        for (int num : flatten) {
            step += Math.abs(num - median) / x;
        }
        return step;
    }
}
