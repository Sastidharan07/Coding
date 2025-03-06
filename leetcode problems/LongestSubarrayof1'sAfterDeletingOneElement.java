//Question:https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
class Solution {
    public int longestSubarray(int[] nums) {
        int c = 0;
        int j = 0;
        int f = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || (nums[i] == 0 && f == 0)) {
                c++;
                if (nums[i] == 0) {
                    f = 1;
                }
            } else {
                while (nums[j] == 1) {
                    j++;
                    c--;
                }
                j++; 
            }
            max = Math.max(max, c);
        }
        return max - 1;
    }
}
