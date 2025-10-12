//Question : https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences/description/
import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // Precompute binomial coefficients C[i][j] = iCj % MOD
        long[][] C = new long[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++)
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
        }

        // Precompute powers of nums[i]^t for t=0..m
        long[][] pow = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            pow[i][0] = 1;
            for (int t = 1; t <= m; t++)
                pow[i][t] = (pow[i][t - 1] * nums[i]) % MOD;
        }

        long[][][] dp = new long[m + 1][m + 1][m + 1];
        dp[m][0][0] = 1;

        for (int i = 0; i < n; i++) {
            long[][][] next = new long[m + 1][m + 1][m + 1];
            for (int r = 0; r <= m; r++) {
                for (int c = 0; c <= m; c++) {
                    for (int o = 0; o <= m; o++) {
                        long val = dp[r][c][o];
                        if (val == 0) continue;
                        for (int t = 0; t <= r; t++) {
                            int nr = r - t;
                            int sum = c + t;
                            int bit = sum & 1;
                            int nc = sum >> 1;
                            int no = o + bit;
                            if (no > m) continue;
                            long mult = (C[r][t] * pow[i][t]) % MOD;
                            next[nr][nc][no] = (next[nr][nc][no] + val * mult) % MOD;
                        }
                    }
                }
            }
            dp = next;
        }

        long res = 0;
        for (int c = 0; c <= m; c++) {
            for (int o = 0; o <= m; o++) {
                if (dp[0][c][o] == 0) continue;
                if (o + Integer.bitCount(c) == k)
                    res = (res + dp[0][c][o]) % MOD;
            }
        }
        return (int) res;
    }
}