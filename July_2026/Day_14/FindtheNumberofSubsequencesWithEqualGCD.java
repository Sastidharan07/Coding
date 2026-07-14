//Question : https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/description/
class Solution {
    public int subsequencePairCount(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt(), mod = (int)1e9 + 7;
        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            int[][] next = new int[m + 1][m + 1];
            for (int g1 = 0; g1 <= m; g1++) {
                for (int g2 = 0; g2 <= m; g2++) {
                    if (dp[g1][g2] == 0) continue;
                    // skip current element (already copied via next init... 
                    // but we copy dp to next first)
                    next[g1][g2] = (next[g1][g2] + dp[g1][g2]) % mod;
                    int n1 = gcd(g1, x), n2 = gcd(g2, x);
                    // add x to S1
                    next[n1][g2] = (next[n1][g2] + dp[g1][g2]) % mod;
                    // add x to S2
                    next[g1][n2] = (next[g1][n2] + dp[g1][g2]) % mod;
                }
            }
            dp = next;
        }

        long ans = 0;
        for (int g = 1; g <= m; g++)
            ans = (ans + dp[g][g]) % mod;
        return (int)ans;
    }

    int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
