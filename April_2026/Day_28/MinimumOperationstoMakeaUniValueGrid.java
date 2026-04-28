//Question : https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] flat = new int[m * n];
        int k = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[k++] = val;
            }
        }

        int rem = flat[0] % x;
        for (int val : flat) {
            if (val % x != rem) return -1;
        }
        
        Arrays.sort(flat);
        int median = flat[flat.length / 2];
        int ops = 0;
        for (int val : flat) {
            ops += Math.abs(val - median) / x;
        }
        return ops;
    }
}
