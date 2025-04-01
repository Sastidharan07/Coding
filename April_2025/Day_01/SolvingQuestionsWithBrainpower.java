//Question : https://leetcode.com/problems/solving-questions-with-brainpower/description/
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1];
            long solve = (i + questions[i][1] < n) ? dp[i + questions[i][1] + 1] + questions[i][0] : questions[i][0];
            dp[i] = Math.max(skip, solve);
        }
        return dp[0];
    }
}
