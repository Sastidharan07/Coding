//Question : https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/
class Solution {
    public int numberOfWays(int n, int x) {
        final long MOD = 1_000_000_007L;

        List<Integer> powers = new ArrayList<>();
        for (int a = 1;; ++a) {
            long p = 1;
            for (int i = 0; i < x; ++i) {
                p *= a;
                if (p > n) break;
            }
            if (p > n) break;
            powers.add((int)p);
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

       
        for (int p : powers) {
            for (int i = n; i >= p; --i) {
                dp[i] = (int)((dp[i] + (long)dp[i - p]) % MOD);
            }
        }

        return dp[n];
    }
}
