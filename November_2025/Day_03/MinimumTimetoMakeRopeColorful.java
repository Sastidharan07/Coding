//Question : https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, max_time = neededTime[0], sum_time = neededTime[0];
        for(int i = 1; i < neededTime.length; i++) {
            if(colors.charAt(i) != colors.charAt(i - 1)) {
                ans += sum_time - max_time;
                max_time = 0;
                sum_time = 0;
            }
            max_time = Math.max(max_time, neededTime[i]);
            sum_time += neededTime[i];
        }
        ans += sum_time - max_time;
        return ans;
    }
}