//Question : https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE, count = 0;
        long res = 0;
        int j = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) count++;
            while (count >= k) {
                if (nums[j] == max) count--;
                j++;
            }
            res += j;
        }
        return res;
    }
}
