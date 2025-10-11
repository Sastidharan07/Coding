//Question : https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/
import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        if (power.length == 0) return 0;

        Arrays.sort(power);
        long[] dp = new long[3]; // dp[0]=current, dp[1]=prev, dp[2]=two back

        int prevOneIdx = -1, prevTwoIdx = -1;
        int n = power.length;
        int i = 0;

        while (i < n) {
            int j = i;
            // Count frequency of current value
            while (j + 1 < n && power[j + 1] == power[i]) j++;
            int freq = j - i + 1;
            int curVal = power[i];

            long take = (long) curVal * freq;

            // Two-back conflict
            if (prevTwoIdx >= 0 && curVal - power[prevTwoIdx] <= 2) {
                take += dp[2];
            } 
            // One-back conflict
            else if (prevOneIdx >= 0 && curVal - power[prevOneIdx] <= 2) {
                take += dp[1];
            } 
            // No conflict
            else {
                take += Math.max(dp[0], Math.max(dp[1], dp[2]));
            }

            // Update rolling dp with overall max
            long curMax = Math.max(take, Math.max(dp[0], Math.max(dp[1], dp[2])));
            dp[2] = dp[1];
            dp[1] = dp[0];
            dp[0] = curMax;

            // Update previous indices
            prevTwoIdx = prevOneIdx;
            prevOneIdx = i;

            i = j + 1; // move to next unique value
        }

        return dp[0];
    }
}