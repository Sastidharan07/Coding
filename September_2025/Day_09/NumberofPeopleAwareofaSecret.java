//Question : https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[1] = 1;
        pref[1] = 1;

        for (int i = 2; i <= n; i++) {
            int L = Math.max(1, i - forget + 1);
            int R = i - delay;
            if (R >= L) {
                dp[i] = (pref[R] - pref[L - 1] + MOD) % MOD;
            }
            pref[i] = (pref[i - 1] + dp[i]) % MOD;
        }

        int start = Math.max(1, n - forget + 1);
        long ans = (pref[n] - pref[start - 1] + MOD) % MOD;
        return (int) ans;
    }
}
