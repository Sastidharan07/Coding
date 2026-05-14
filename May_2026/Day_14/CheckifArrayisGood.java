//Question : https://leetcode.com/problems/check-if-array-is-good/description/
class Solution {
    public boolean isGood(int[] nums) {
        int[] numsCount = new int[nums.length];
        for (int num : nums) {
            if (num >= nums.length) {
                return false;
            }
            numsCount[num]++;
            if(num < nums.length - 1 && numsCount[num] > 1) {
                return false;
            }
        }
        for (int i = 1; i < numsCount.length; i++) {
            if(numsCount[i] == 0) {
                return false;
            }
        }
        return true;
    }
}