//Question:https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] a = {-1, -1};
        int c = -1;
        int d = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (c == -1) {
                    c = i; 
                }
                d = i;
            }
        }

        a[0] = c;
        a[1] = d;

        return a;
    }
}
