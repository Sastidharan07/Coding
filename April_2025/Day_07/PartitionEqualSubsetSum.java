//Question : https://leetcode.com/problems/partition-equal-subset-sum/description/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        return canPartition(nums, 0, sum / 2, dp);
    }

    private boolean canPartition(int[] nums, int i, int sum, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (i >= nums.length || sum < 0)
            return false;
        if (dp[i][sum] != null)
            return dp[i][sum];
        return dp[i][sum] = canPartition(nums, i + 1, sum - nums[i], dp) ||
                canPartition(nums, i + 1, sum, dp);
    }
}
