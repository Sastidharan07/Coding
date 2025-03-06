//Question:https://leetcode.com/problems/rotate-array/description/
class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        k = k % nums.length;
        
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j] = nums[i];
            j++;
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp[j] = nums[i];
            j++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
