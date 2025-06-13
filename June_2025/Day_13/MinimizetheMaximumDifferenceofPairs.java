//Question : https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/
class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length-1] - nums[0];
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; ) {
            if (nums[i] - nums[i-1] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
