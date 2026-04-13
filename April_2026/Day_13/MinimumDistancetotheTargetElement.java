//Question : https://leetcode.com/problems/minimum-distance-to-the-target-element/description/
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        
        for (int d = 0; d < n; d++) {
            if (start - d >= 0 && nums[start - d] == target)
                return d;
            
            if (start + d < n && nums[start + d] == target)
                return d;
        }
        
        return -1;
    }
}