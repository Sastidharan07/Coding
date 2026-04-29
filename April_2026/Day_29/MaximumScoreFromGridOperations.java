//Question : https://leetcode.com/problems/maximum-score-from-grid-operations/description/
import java.util.*;

class Solution {
    public long maximumScore(int[][] A) {
        int n = A.length;

        long[][] B = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                B[j][i + 1] = B[j][i] + A[i][j];
            } 
        }

        long[] pdp = new long[n + 1];
        long[] pep = new long[n + 1];

        for (int j = 1; j < n; j++) {
            long[] dp = new long[n + 1];
            long[] ep = new long[n + 1];

            for (int pb = 0; pb <= n; pb++) {
                for (int cb = 0; cb <= n; cb++) {

                    long pv = 0;
                    if (cb > pb) {
                        pv = B[j - 1][cb] - B[j - 1][pb];
                    }

                    long cv = 0;
                    if (cb < pb) {
                        cv = B[j][pb] - B[j][cb];
                    }

                    dp[cb] = Math.max(dp[cb],
                            Math.max(pv + pdp[pb], pep[pb])
                    );

                    ep[cb] = Math.max(ep[cb],
                            Math.max(cv + pep[pb],
                                     cv + pv + pdp[pb])
                    );
                }
            }

            pdp = dp;
            pep = ep;
        }

        long ans = 0;
        for (long v : pep) {
            ans = Math.max(ans, v);
        }

        return ans;
    }
}    