//Question : https://leetcode.com/problems/rotate-function/description/
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int numSum = Arrays.stream(nums).sum();

        int f0 = 0;
        for(int i=0;i<n;i++){
            f0 += i*nums[i];
        }

        int ans = f0;
        for(int i=1;i<n;i++){
            f0 += numSum - (n*nums[n-i]);
            ans = Math.max(f0,ans);
        }

        return ans;
    }
}