//Question : https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description/
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;

        for (int targetSum = 0; targetSum < k; targetSum++) {
            int[] dp = new int[k];

            for (int num : nums) {
                int remainder = num % k;
                int prevRemainder = (targetSum - remainder + k) % k;

                dp[remainder] = Math.max(dp[remainder], dp[prevRemainder] + 1);
            }

            for (int len : dp) {
                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength;
    }
}
