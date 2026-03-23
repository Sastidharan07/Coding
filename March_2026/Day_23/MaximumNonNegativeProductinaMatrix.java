//Question : https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/description/
class Solution {

    private int m, n;
    private long[][][] dp; 
    private int mod = 1000000007;

    public int maxProductPath(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        dp = new long[m][n][2];

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }

        long[] res = solve(0, 0, grid);

        return res[0] < 0 ? -1 : (int)(res[0] % mod);
    }

    private long[] solve(int x, int y, int[][] grid) {

        if(x == m - 1 && y == n - 1) {
            return new long[]{grid[x][y], grid[x][y]};
        }

        if(dp[x][y][0] != Long.MIN_VALUE) {
            return dp[x][y];
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if(x + 1 < m) {
            long[] down = solve(x + 1, y, grid);

            long a = grid[x][y] * down[0];
            long b = grid[x][y] * down[1];

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        if(y + 1 < n) {
            long[] right = solve(x, y + 1, grid);

            long a = grid[x][y] * right[0];
            long b = grid[x][y] * right[1];

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        dp[x][y][0] = maxVal;
        dp[x][y][1] = minVal;

        return dp[x][y];
    }
}
