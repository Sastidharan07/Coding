//Question : https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/description/
public class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += fruits[i][i];
        }

        res += dp(fruits, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = fruits[i][j];
                fruits[i][j] = fruits[j][i];
                fruits[j][i] = temp;
            }
        }

        res += dp(fruits, n);

        return res;
    }

    private int dp(int[][] fruits, int n) {
        int[][] grid = new int[n][n];
        grid[0][n - 1] = fruits[0][n - 1];

        for (int i = 1; i < n - 1; i++) {
            for (int j = Math.max(i + 1, n - 1 - i); j < n; j++) {
                int best = grid[i - 1][j];
                if (j - 1 >= 0) best = Math.max(best, grid[i - 1][j - 1]);
                if (j + 1 < n) best = Math.max(best, grid[i - 1][j + 1]);

                grid[i][j] = best + fruits[i][j];
            }
        }

        return grid[n - 2][n - 1];
    }
}
