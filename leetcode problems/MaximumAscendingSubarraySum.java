//Question : https://leetcode.com/problems/maximum-ascending-subarray-sum/
class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0]; // Start with the first element
        int max = sum; // Initialize max with the first element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[j - 1]) {
                sum += nums[j]; // Add current element to sum if it's ascending
            } else {
                sum = nums[j]; // Reset sum if it's not ascending
            }
            max = Math.max(max, sum); // Update max if current sum is greater
        }
        return max;
    }
}
