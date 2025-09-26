//Question : https://leetcode.com/problems/valid-triangle-number/description/
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int rs = 0;

        for (int k = 2; k < nums.length; k++) {
            int l = 0;
            int r = k - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[k]) {
                    rs += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return rs;
    }
}
