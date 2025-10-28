//Question : https://leetcode.com/problems/make-array-elements-equal-to-zero/description/
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        
        // Calculate total sum
        for (int num : nums) {
            sum += num;
        }
        
        int leftSum = 0;
        int rightSum = sum;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (leftSum - rightSum >= 0 && leftSum - rightSum <= 1) {
                    ans++;
                }
                if (rightSum - leftSum >= 0 && rightSum - leftSum <= 1) {
                    ans++;
                }
            } else {
                leftSum += nums[i];
                rightSum -= nums[i];
            }
        }
        return ans;
    }
}