//Question : https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
class Solution {
    public int minOperations(int[] nums) {
        int c = 0;
        int n = nums.length;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                c++;
            }
        }
        for (int num : nums) {
            if (num == 0) {
                return -1;
            }
        }
        return c;
    }
}
