//Question : https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++){
            pows[i] = (pows[i - 1] * 2) % mod;
        }
        int left = 0, right = n - 1, res = 0;
        while (left <= right){
            if (nums[left] + nums[right] > target){
                right--;
            } else {
                res = (res + pows[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}
