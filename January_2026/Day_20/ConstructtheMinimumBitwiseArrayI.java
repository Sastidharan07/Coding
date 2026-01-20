//Question : https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/description/
class Solution {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = transform(nums.get(i));
        }
        return result;
    }

    private int transform(int val) {

        // Case: val % 4 == 1
        if ((val & 3) == 1) {
            return val - 1;
        }

        // Case: val % 4 == 3
        if ((val & 3) == 3) {
            int shift = 0;
            int temp = val >> 1;

            while ((temp & 1) == 1) {
                shift++;
                temp >>= 1;
            }
            return val - (1 << shift);
        }

        // Edge case (only for val = 2)
        return -1;
    }
}