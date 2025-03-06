//Question:https://leetcode.com/problems/minimum-size-subarray-sum/description/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; 
            while (sum >= target) {
                min1 = Math.min(min1, right - left + 1); 
                sum -= nums[left]; // Shrink the window by removing nums[left]
                left++; // Move the left pointer forward
            }
        }

        // If no valid subarray is found, return 0
        return min1 == Integer.MAX_VALUE ? 0 : min1;
    }
}
