//Question : https://leetcode.com/problems/new-21-game/description/
class Solution {
    public double new21Game(int N, int K, int maxPts) {
        if (K == 0 || N >= K - 1 + maxPts) return 1.0;
        double[] dp = new double[N + 1];
        dp[0] = 1.0;
        double probability = 0.0, windowSum = 1.0;
        for (int i = 1; i <= N; i++) {
            dp[i] = windowSum / maxPts;
            if (i < K) windowSum += dp[i];
            else probability += dp[i];
            if (i >= maxPts) windowSum -= dp[i - maxPts];
        }
        return probability;
    }
}
