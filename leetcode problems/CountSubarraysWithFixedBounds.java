//Question : https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastMin = -1, lastMax = -1, lastInvalid = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
            }
            if (nums[i] == minK) {
                lastMin = i;
            }
            if (nums[i] == maxK) {
                lastMax = i;
            }
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastInvalid) {
                count += validStart - lastInvalid;
            }
        }

        return count;
    }
}
